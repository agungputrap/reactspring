import "react-bootstrap-table-next/dist/react-bootstrap-table2.min.css";
import agent from "../agent";
import React from "react";
import HeaderTes from "./HeaderTes";
import styled from "styled-components";
import { APP_LOAD, REDIRECT } from "../constants/actionTypes";
import { connect } from "react-redux";
import { Route, Switch } from "react-router-dom";
import { store } from "../store";
import { push } from "react-router-redux";
import Home from "./HomeTes";
import Login from "./LoginTes";
import Register from "./RegisterTes";
import Dashboard from "./Dashboard";
import AddRecipient from "./Recipient/AddRecipient";
import SendMoney from "./Dashboard/SendMoney";
import Promo from "./Dashboard/Promo";

const mapStateToProps = state => {
  return {
    appLoaded: state.common.appLoaded,
    appName: state.common.appName,
    currentUser: state.common.currentUser,
    redirectTo: state.common.redirectTo,
    pathname: state.common.path,
    error: state.common.error
  };
};

const mapDispatchToProps = dispatch => ({
  onLoad: (payload, token) => {
    dispatch({ type: APP_LOAD, payload, token, skipTracking: true });
  },
  onRedirect: () => dispatch({ type: REDIRECT })
});

class AppOther extends React.Component {
  componentWillReceiveProps(nextProps) {
    if (nextProps.redirectTo) {
      // this.context.router.replace(nextProps.redirectTo);
      store.dispatch(push(nextProps.redirectTo));
      this.props.onRedirect();
    }
  }

  componentWillMount() {
    const token = window.localStorage.getItem("jwt");
    if (token) {
      agent.setToken(token);
    }

    this.props.onLoad(token ? agent.Auth.current() : null, token);
  }

  render() {
    return (
      <div>
        <HeaderTes
          appName={this.props.appName}
          currentUser={this.props.currentUser}
          error={this.props.err}
        />
        <Switch>
          <Route exact path="/" component={Home} />
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
          <Route path="/dashboard" component={Dashboard} />
          <Route path="/recipient/add" component={AddRecipient} />
          <Route path="/sendmoney" component={SendMoney} />
          <Route path="/promo" component={Promo} />
        </Switch>
      </div>
    );
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(AppOther);
