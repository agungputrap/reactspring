import React from "react";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import agent from "../agent";
import { store } from "../store";
import { push } from "react-router-redux";
import {
  HOME_PAGE_LOADED,
  HOME_PAGE_UNLOADED,
  APPLY_TAG_FILTER,
  CHANGE_PAGE,
  REDIRECT
} from "../constants/actionTypes";
//import "../assets/css/home.css";
import "../assets/css/general.css";
import { debounce } from "lodash";
import { GetDiscountedKurs, GetFormattedMoney } from "./../utils/KursUtil";

var styles = {
  formConvert: {
    width: "375px",
    height: "545px",
    margin: "auto",
    backgroundColor: "#1e2b6f",
    fontFamily: "Roboto",
    color: "#ffffff",
    paddingTop: "10px",
    paddingBottom: "20px",
    paddingLeft: "20px",
    paddingRight: "20px"
  },
  btnTransparent: {
    backgroundColor: "transparent",
    color: "#ffffff",
    width: "75px",
    border: "none",
    borderRadius: "0px",
    fontFamily: "Roboto",
    fontSize: "20px",
    margin: "0"
  }
};

const allKurs = [{ code: "IDR" }, { code: "GPB" }, { code: "EUR" }];

const mapStateToProps = state => ({
  ...state.home,
  appName: state.common.appName,
  token: state.common.token
});

const mapDispatchToProps = dispatch => ({
  onClickTag: (tag, pager, payload) =>
    dispatch({ type: APPLY_TAG_FILTER, tag, pager, payload }),
  onLoad: (tab, pager, payload) =>
    dispatch({ type: HOME_PAGE_LOADED, tab, pager, payload }),
  onUnload: () => dispatch({ type: HOME_PAGE_UNLOADED }),
  onChangePage: path => dispatch({ type: CHANGE_PAGE, payload: path }),
  onRedirect: () => dispatch({ type: REDIRECT })
});

class Home extends React.Component {
  constructor() {
    super();

    this.state = {
      fromCode: "GBP",
      toCode: "IDR",
      from: 0,
      to: 0,
      kurs: 0,
      kursAfterDiscount: 0
    };
  }
  componentWillMount() {
    this.props.onChangePage("home");
    if (this.props.token) {
      store.dispatch(push("/dashboard"));
      this.props.onRedirect();
    }
    /*const articlesPromise = this.props.token ?
      agent.Articles.feed :
      agent.Articles.all;*/

    //this.props.onLoad(tab, articlesPromise, Promise.all([agent.Tags.getAll(), articlesPromise()]));
  }

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
      to: 0,
      kurs: 0,
      kursAfterDiscount: 0
    });
  }

  debounceEvent(...args) {
    this.debouncedEvent = debounce(...args);
    return e => {
      e.persist();
      return this.debouncedEvent(e);
    };
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
    var query = "?q=" + change + "&compact=y";
    fetch(base + query)
      .then(result => {
        return result.json();
      })
      .then(data => {
        console.log("data", data);
        var vl = data[change].val;
        var discount = vl - GetDiscountedKurs(vl);
        this.setState({
          from: value,
          to: (value * discount).toFixed(2),
          kurs: vl,
          kursAfterDiscount: discount
        });
      });
  }

  clickedPromo() {
    console.log("CLICKED");
    // window.open("https://www.transfree.id/gbp-idr", "_blank");
    store.dispatch(push("/promo"));
  }

  onClickChangeKurs(event, sts) {
    event.preventDefault();
    if (sts === "from") {
      this.setState({
        fromCode: event.target.text,
        from: 0,
        to: 0,
        kurs: 0,
        kursAfterDiscount: 0
      });
    } else {
      this.setState({
        toCode: event.target.text,
        from: 0,
        to: 0,
        kurs: 0,
        kursAfterDiscount: 0
      });
    }
  }

  render() {
    const ListAllKurs = props => {
      return allKurs.map((name, index) => {
        return (
          <li key={index}>
            <a
              href="#"
              onClick={ev => {
                this.onClickChangeKurs(ev, props.status);
              }}
            >
              {name.code}
            </a>
          </li>
        );
      });
    };

    return (
      <div className="home-page">
        <Helmet>
          <style>{"body { background-color: #233685 }"}</style>
        </Helmet>
        <img
          src="/img/circle.svg"
          data-component="Imgcircle"
          alt=""
          style={{
            width: "70%",
            position: "absolute",
            top: "0",
            left: "0",
            zIndex: "-9999"
          }}
        />

        <div className="row" id="rowForm" data-component="RowForm">
          <div className="col-lg-8">
            <div className="row">
              <a href="/">
                <img
                  src="/img/logo.png"
                  id="imgSmall"
                  className="img-responsive"
                  alt="transfree logo"
                />
              </a>
              <span id="textSmall" data-component="TextSmall">
                Make international transfer feels like local transfer
              </span>
            </div>

            <div className="row text-center" id="featuresPosition">
              <div className="col-sm-8">
                <div className="col-sm-3">
                  <img src="img/1.png" alt="" />
                  <br />
                  <span>5x cheaper, 3x faster than your bank</span>
                </div>
                <div className="col-sm-3">
                  <img src="img/2.png" alt="" />
                  <br />
                  <span>350+ customer</span>
                </div>
                <div className="col-sm-3">
                  <img src="img/3.png" alt="" />
                  <br />
                  <span>Rp 10 Billion+ transaction</span>
                </div>
                <div className="col-sm-3">
                  <img src="img/4.png" alt="" />
                  <br />
                  <span>Official partner of Persatuan Pelajar Indonesia</span>
                </div>
              </div>
              <div className="col-md-6" />
            </div>
          </div>
          <div
            id="formPosition"
            className="text-center col-lg-4"
            style={styles.formConvert}
          >
            <div className="input-group" data-component="InputForm">
              <div className="input-group-btn">
                <button
                  className="btn dropdown-toggle"
                  type="button"
                  style={styles.btnTransparent}
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  {this.state.fromCode}
                </button>
                <ul className="dropdown-menu">
                  <ListAllKurs status="from" />
                </ul>
              </div>
              <input
                type="text"
                className="form-control input-currency"
                id="from"
                placeholder=""
                style={{ height: "60px" }}
                // value={this.state.from}
                onChange={this.debounceEvent(this.changeFrom, 500)}
              />
            </div>

            <div style={{ textAlign: "left", paddingLeft: "5%" }}>
              <p>{`kurs : ${GetFormattedMoney(this.state.kurs)}`}</p> <br />
              <p>{`Discounted kurs : ${GetFormattedMoney(
                this.state.kursAfterDiscount
              )}`}</p>
            </div>

            <div className="input-group" data-component="InputForm">
              <div className="input-group-btn">
                <button
                  className="btn dropdown-toggle"
                  type="button"
                  style={styles.btnTransparent}
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  {this.state.toCode}
                </button>
                <ul className="dropdown-menu">
                  <ListAllKurs status="to" />
                </ul>
              </div>
              <input
                type="text"
                className="form-control"
                id="to"
                placeholder=""
                style={{ height: "60px" }}
                value={this.state.to}
              />
            </div>

            <div
              className="form-actions text-right"
              style={{ marginTop: "40px", marginBottom: "55px" }}
            >
              <button
                type="button"
                className="btn btn-promo"
                onClick={this.clickedPromo}
              >
                Promo
              </button>
              <button type="sumbit" className="btn btn-prime">
                Send
              </button>
            </div>

            <h4 style={{ width: "87%", margin: "auto" }}>
              Everyone loves promo, and we want you to experience the best way
              to transfer money abroad. Check all our offers in the promo page
            </h4>
          </div>
        </div>
      </div>
    );
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Home);
