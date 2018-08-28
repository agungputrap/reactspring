import React, { Component } from "react";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import { store } from "../../store";
import { push } from "react-router-redux";
import agent from "../../agent";
import { Link } from "react-router-dom";
import ListPromo from "./../Promo/ListPromo";
import { MsToDateIndo } from "./../../utils/StringUtil";
import { filter } from "lodash";
import {
  CHANGE_PAGE,
  DASHBOARD_PAGE_UNLOAD,
  REDIRECT,
  TRANSACTION_PAGE_LOADED,
  BUY_PROMO
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
    }),
  onBuyPromo: promo => dispatch({ type: BUY_PROMO, payload: promo })
});

class Promo extends Component {
  constructor() {
    super();
    this.state = {
      promos: []
    };
  }

  componentWillUnmount() {
    this.props.onUnload();
  }
  componentWillMount() {
    this.props.onChangePage("promo");
    agent.Promo.allActive().then(res => {
      this.setState({ promos: res });
    });
  }

  buyPromo = id => {
    if (this.props.currentUser) {
      console.log("BOLEH BELI");
      let promo = filter(this.state.promos, o => {
        return o.id === id;
      })[0];
      this.props.onBuyPromo(promo);
      store.dispatch(push("/sendmoney"));
    } else {
      console.log("TDK BOLEH BELI");
      store.dispatch(push("/login"));
    }
  };

  render() {
    return (
      <div className="container">
        <div className="panel panel-primary" style={{ background: "#ffffff" }}>
          <Helmet>
            <style>{"body { background-color: #d3dbfd }"}</style>
          </Helmet>
          <div className="panel-heading">
            <h4>Promo</h4>
          </div>
          <div className="panel-body">
            <ListPromo promo={this.state.promos} buyPromo={this.buyPromo} />
          </div>
        </div>
      </div>
    );
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Promo);
