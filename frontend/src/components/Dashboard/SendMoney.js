import React, { Component } from "react";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import { store } from "../../store";
import { push } from "react-router-redux";
import agent from "../../agent";
import { Link } from "react-router-dom";
import { debounce } from "lodash";
import ListRecipient from "./ListRecipient";
import { GetCurrencySymbol, GetFormattedMoney } from "./../../utils/KursUtil";
import {
  CHANGE_PAGE,
  DASHBOARD_PAGE_UNLOAD,
  REDIRECT,
  TRANSACTION_PAGE_LOADED,
  SENT_MONEY
} from "../../constants/actionTypes";

const styles = {
  separatorLeft: {
    borderRight: "1px solid #b2b2b2",
    boxShadow: "5px 0px 1px -4px #888"
  },
  separatorRight: {
    borderLeft: "1px solid #b2b2b2",
    boxShadow: "-4px 0px 1px -4px #888"
  },
  formRegister: {
    fontFamily: `'Roboto', sans-serif`,
    paddingTop: "10px",
    paddingBottom: "20px",
    paddingLeft: "20px,",
    paddingRight: "20px",
    marginTop: "75px",
    marginLeft: "45px"
  }
};

const mapStateToProps = state => ({
  ...state.home,
  appName: state.common.appName,
  token: state.common.token,
  currentUser: state.common.currentUser,
  transactions: state.common.transactions,
  promoBought: state.common.promoBought
});

const mapDispatchToProps = dispatch => ({
  onUnload: () => dispatch({ type: DASHBOARD_PAGE_UNLOAD }),
  onChangePage: path => dispatch({ type: CHANGE_PAGE, payload: path }),
  onRedirect: () => dispatch({ type: REDIRECT }),
  onSubmit: (from, to, fromCode, toCode, recipient, kurs, kursIdr, promoId) =>
    dispatch({
      type: "SENT_MONEY",
      payload: agent.Transaksi.sentMoney(
        from,
        to,
        fromCode,
        toCode,
        recipient,
        kurs,
        kursIdr,
        promoId
      )
    })
});

class SendMoney extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fromCode: "GBP",
      toCode: "IDR",
      from: 0,
      to: 0,
      recipients: [],
      recipient: "",
      kurs: 0,
      kursIdr: 0
    };

    this.sendMoney = ev => {
      ev.preventDefault();
      console.log("STATE", this.state);
      let promoId = this.props.promoBought ? this.props.promoBought.id : null;
      this.props.onSubmit(
        this.state.from,
        this.state.to,
        this.state.fromCode,
        this.state.toCode,
        this.state.recipient,
        this.state.kurs,
        this.state.kursIdr,
        promoId
      );
    };
  }

  componentDidMount = () => {
    let idCust = this.props.currentUser ? this.props.currentUser.id : 0;
    agent.Recipient.all(idCust).then(result => {
      this.setState({ recipients: result });
    });
  };

  componentWillUnmount() {
    this.props.onUnload();
    this.timer = null;
    this.debouncedEvent.cancel();
  }

  swapCurrency() {
    this.setState({
      fromCode: this.state.toCode,
      toCode: this.state.fromCode,
      from: 0,
      to: 0
    });
  }

  debounceEvent(...args) {
    this.debouncedEvent = debounce(...args);
    return e => {
      e.persist();
      return this.debouncedEvent(e);
    };
  }

  changeRecipient(value) {
    this.setState({ recipient: value });
  }

  changeFrom(event) {
    this.getCurrencyFromState(
      this.state.fromCode,
      this.state.toCode,
      event.target.value
    );
  }

  getCurrencyFromState(from, to, value) {
    var base = "https://free.currencyconverterapi.com/api/v5/convert";
    var change = from + "_" + to;
    var idr = from + "_IDR";
    var query = "?q=" + change + "," + idr + "&compact=y";
    fetch(base + query)
      .then(result => {
        return result.json();
      })
      .then(data => {
        var vl = data[change].val;
        var vl2 = data[idr].val;
        this.setState({
          from: value,
          to: (value * vl).toFixed(2),
          kurs: vl,
          kursIdr: vl2
        });
      });
  }

  render() {
    let listRecipient = this.state.recipients.map((name, index) => {
      return (
        <option key={index} value={name.value}>
          {name.text}
        </option>
      );
    });

    let BoughtPromo = () => {
      console.log("promo", this.props.promoBought);
      if (this.props.promoBought) {
        const prom = this.props.promoBought;
        return (
          <div className="col-sm-5 col-md-5">
            <h3>PROMO</h3>
            <div className="thumbnail">
              <div className="caption">
                <h3 style={{ textAlign: "center" }}>{prom.nama}</h3>
                <p>
                  {"Currency Rate " +
                    GetCurrencySymbol(prom.kursKe) +
                    "" +
                    GetFormattedMoney(prom.kurs)}
                </p>
                <br />
                <p>
                  <a>Get Rp 25,000 with a referral code</a>
                </p>
                <h4 style={{ textAlign: "center" }}>
                  {"Flexible Amount Below " +
                    GetCurrencySymbol(prom.kursDari) +
                    "" +
                    GetFormattedMoney(prom.nominal)}
                </h4>
              </div>
              <div style={{ backgroundColor: "#F17424" }}>
                <h3 style={{ textAlign: "center", color: "#ffffff" }}>
                  Flexible
                </h3>
              </div>
            </div>
          </div>
        );
      }
      return <div />;
    };

    return (
      <div className="container">
        <div className="panel panel-primary" style={{ background: "#ffffff" }}>
          <Helmet>
            <style>{"body { background-color: #d3dbfd }"}</style>
          </Helmet>
          <div className="panel-heading">
            <h4>DASHBOARD</h4>
          </div>
          <div className="panel-body">
            <div className="col-lg-4">
              <div style={{ textAlign: "center" }}>
                <h2>
                  {this.props.currentUser ? this.props.currentUser.nama : ""}
                </h2>
              </div>
              <div className="row">
                <div style={{ textAlign: "center" }}>
                  <h4>Total Transaction</h4>
                </div>
                <div>
                  <table className="table">
                    <tr>
                      <td>RP </td>
                      <td>
                        {this.props.transactions.totalTransaksiIdr.toLocaleString(
                          "id-ID",
                          { minimumFractionDigits: 2 }
                        )}
                      </td>
                    </tr>
                  </table>
                </div>
              </div>
              <div className="row text-center">
                <button className="btn btn-info">Edit Profile</button>
              </div>
            </div>
            <div className="col-lg-8" style={styles.separatorRight}>
              <div style={{ textAlign: "center" }}>
                <h2>Send Money</h2>
              </div>
              <div
                id="formPosition"
                className="text-center"
                style={styles.formConvert}
              >
                <div
                  className="input-group group-send"
                  data-component="InputForm"
                >
                  <div className="input-group-addon group-send-addon">
                    {this.state.fromCode}
                  </div>
                  <input
                    type="text"
                    className="form-control input-currency"
                    id="from"
                    placeholder=""
                    // value={this.state.from}
                    onChange={this.debounceEvent(this.changeFrom, 500)}
                  />
                </div>

                <div>
                  <button
                    className="btn"
                    style={{ backgroundColor: "#ffa91f" }}
                    onClick={this.swapCurrency.bind(this)}
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      viewBox="0 0 512 512"
                      width="1em"
                      height="1em"
                      fill="white"
                    >
                      <path d="M440.935 12.574l3.966 82.766C399.416 41.904 331.674 8 256 8 134.813 8 33.933 94.924 12.296 209.824 10.908 217.193 16.604 224 24.103 224h49.084c5.57 0 10.377-3.842 11.676-9.259C103.407 137.408 172.931 80 256 80c60.893 0 114.512 30.856 146.104 77.801l-101.53-4.865c-6.845-.328-12.574 5.133-12.574 11.986v47.411c0 6.627 5.373 12 12 12h200.333c6.627 0 12-5.373 12-12V12c0-6.627-5.373-12-12-12h-47.411c-6.853 0-12.315 5.729-11.987 12.574zM256 432c-60.895 0-114.517-30.858-146.109-77.805l101.868 4.871c6.845.327 12.573-5.134 12.573-11.986v-47.412c0-6.627-5.373-12-12-12H12c-6.627 0-12 5.373-12 12V500c0 6.627 5.373 12 12 12h47.385c6.863 0 12.328-5.745 11.985-12.599l-4.129-82.575C112.725 470.166 180.405 504 256 504c121.187 0 222.067-86.924 243.704-201.824 1.388-7.369-4.308-14.176-11.807-14.176h-49.084c-5.57 0-10.377 3.842-11.676 9.259C408.593 374.592 339.069 432 256 432z" />
                    </svg>
                  </button>
                </div>

                <div
                  className="input-group group-send"
                  data-component="InputForm"
                >
                  <div className="input-group-addon">{this.state.toCode}</div>
                  <input
                    type="text"
                    className="form-control"
                    id="to"
                    placeholder=""
                    value={this.state.to}
                  />
                </div>

                <div>
                  {/* <ListRecipient
                    recipients={this.state.recipients}
                    value={this.state.recipient}
                  /> */}
                  <select
                    className="form-control group-send"
                    value={this.state.recipient}
                    onChange={ev => this.changeRecipient(ev.target.value)}
                  >
                    <option value="" disabled hidden>
                      -- recipient --
                    </option>
                    {listRecipient}
                  </select>
                </div>

                <BoughtPromo />

                <div
                  className="form-actions text-right"
                  style={{ marginTop: "40px", marginBottom: "55px" }}
                >
                  {/* <button type="button" className="btn btn-promo">
                    Promo
                  </button> */}
                  <button
                    type="submit"
                    className="btn btn-prime"
                    onClick={this.sendMoney}
                  >
                    Send
                  </button>
                </div>
              </div>
              <div className="row text-right">
                {/* <button className="btn btn-info" onClick={this.addNewRecipient}>
                  Add
                </button> */}
                <Link to="/dashboard" className="btn btn-info">
                  Back
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(SendMoney);
