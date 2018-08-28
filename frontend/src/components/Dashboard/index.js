import React, { Component } from "react";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import { store } from "../../store";
import { push } from "react-router-redux";
import agent from "../../agent";
import ListTransaksi from "./ListTransaksi";
import { Link } from "react-router-dom";
import DashboardUser from "./DashboardUser";
import DashboardAdmin from "./DashboardAdmin";
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

class Dashboard extends Component {
  constructor() {
    super();
    this.state = {};
  }

  render() {
    if (
      this.props.currentUser &&
      this.props.currentUser.peran === "ROLE_USER"
    ) {
      return <DashboardUser />;
    }
    return <DashboardAdmin />;
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Dashboard);
