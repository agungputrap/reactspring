import React, { Component } from "react";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import { store } from "../../store";
import { push } from "react-router-redux";
import agent from "../../agent";
import ListTransaksi from "./ListTransaksi";
import { Link } from "react-router-dom";
import {
  CHANGE_PAGE,
  DASHBOARD_PAGE_UNLOAD,
  REDIRECT,
  TRANSACTION_PAGE_LOADED
} from "../../constants/actionTypes";

const styles = {
  separatorLeft: {
    borderRight: "1px solid #b2b2b2",
    boxShadow: "5px 0px 1px -4px #888"
  },
  separatorRight: {
    borderLeft: "1px solid #b2b2b2",
    boxShadow: "-4px 0px 1px -4px #888"
  }
};

const Promise = global.Promise;

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
  onAllTransactions: idCust =>
    dispatch({
      type: TRANSACTION_PAGE_LOADED,
      payload: agent.Transaksi.allTransactions(idCust)
    })
});

class DashboardUser extends Component {
  constructor() {
    super();
    this.state = {
      transResponse: {
        idPengguna: "",
        totalTransaksiIdr: 0,
        transaksi: [
          {
            waktuTransaksi: null,
            waktuTransaksiStr: "",
            nominalKirim: 0,
            kursDari: "",
            kursKe: "",
            namaPenerima: "",
            namaPengirim: "",
            idCustomerPenerima: null,
            nominalIdr: 0,
            status: ""
          }
        ]
      }
    };
  }
  componentWillUnmount() {
    this.props.onUnload();
  }
  componentWillMount() {
    this.props.onChangePage("dashboard");
    if (this.props.token) {
    } else {
      store.dispatch(push("/"));
      this.props.onRedirect();
    }
    let idCust = this.props.currentUser ? this.props.currentUser.id : 0;
    this.props.onAllTransactions(idCust);
  }
  componentDidMount = () => {
    this.setState({ transResponse: this.props.transactions });
  };

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
                <h2>Transaction History</h2>
              </div>
              <div>
                <table className="table">
                  <thead>
                    <tr>
                      <th>No.</th>
                      <th>Date</th>
                      <th>Recipient</th>
                      <th>Amount</th>
                      <th>Status</th>
                    </tr>
                  </thead>
                  <ListTransaksi
                    transaksi={this.props.transactions.transaksi}
                  />
                </table>
              </div>
              <div className="row text-right">
                <Link to="/recipient/add" className="btn btn-info">
                  Add Recipient
                </Link>
                <Link to="/sendmoney" className="btn btn-info">
                  Send Money
                </Link>
                <Link
                  to="/promo"
                  className="btn"
                  style={{
                    backgroundColor: "#ffbb48",
                    borderColor: "#ffbb48",
                    color: "#ffffff"
                  }}
                >
                  Promo
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
)(DashboardUser);
