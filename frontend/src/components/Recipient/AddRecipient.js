import React, { Component } from "react";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import { store } from "../../store";
import { push } from "react-router-redux";
import agent from "../../agent";
import { Link } from "react-router-dom";
import {
  CHANGE_PAGE,
  DASHBOARD_PAGE_UNLOAD,
  REDIRECT,
  TRANSACTION_PAGE_LOADED,
  ADD_RECIPIENT
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
  transactions: state.common.transactions
});

const mapDispatchToProps = dispatch => ({
  onUnload: () => dispatch({ type: DASHBOARD_PAGE_UNLOAD }),
  onChangePage: path => dispatch({ type: CHANGE_PAGE, payload: path }),
  onRedirect: () => dispatch({ type: REDIRECT }),
  onSubmit: payload => dispatch({ type: ADD_RECIPIENT })
});

class AddRecipient extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullname: "",
      bank: "",
      accountNumber: "",
      iban: ""
    };

    this.addNewRecipient = ev => {
      ev.preventDefault();
      const payload = agent.Recipient.add(
        this.state.fullname,
        this.state.bank,
        this.state.accountNumber,
        this.state.iban
      );
      this.props.onSubmit(payload);
    };

    this.changeFormField = (type, value) => {
      if (type === "fullname") this.setState({ fullname: value });
      else if (type === "bank") this.setState({ bank: value });
      else if (type === "accountNumber")
        this.setState({ accountNumber: value });
      else if (type === "iban") this.setState({ iban: value });
    };
  }

  render() {
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
                <h2>Add Recipient</h2>
              </div>
              <div>
                <div className="form-signup" style={styles.formRegister}>
                  <input
                    name="fullname"
                    placeholder="Full Name"
                    className="form-control"
                    type="text"
                    style={{ marginBottom: "25px", width: "475px" }}
                    value={this.state.fullname}
                    onChange={ev =>
                      this.changeFormField("fullname", ev.target.value)
                    }
                  />
                  <input
                    name="bank"
                    placeholder="Bank Name"
                    className="form-control"
                    type="text"
                    style={{ marginBottom: "25px", width: "475px" }}
                    value={this.state.bank}
                    onChange={ev =>
                      this.changeFormField("bank", ev.target.value)
                    }
                  />
                  <input
                    name="accountNumber"
                    placeholder="ID Number"
                    className="form-control"
                    type="text"
                    style={{ marginBottom: "25px", width: "475px" }}
                    value={this.state.accountNumber}
                    onChange={ev =>
                      this.changeFormField("accountNumber", ev.target.value)
                    }
                  />
                  <input
                    name="iban"
                    placeholder="IBAN or Short Code (if any)"
                    className="form-control"
                    type="text"
                    style={{ marginBottom: "25px", width: "475px" }}
                    value={this.state.iban}
                    onChange={ev =>
                      this.changeFormField("iban", ev.target.value)
                    }
                  />
                </div>
              </div>
              <div className="row text-right">
                <button className="btn btn-info" onClick={this.addNewRecipient}>
                  Add
                </button>
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
)(AddRecipient);
