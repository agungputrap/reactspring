import { Link } from "react-router-dom";
import ListErrors from "./ListErrors";
import React from "react";
import agent from "../agent";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import styled from "styled-components";
import {
  UPDATE_FIELD_AUTH,
  LOGIN,
  LOGIN_PAGE_UNLOADED,
  CHANGE_PAGE
} from "../constants/actionTypes";
import "../assets/css/login.css";

const Bottom = styled.div`
  width: 100%;
  height: 128px;
  background: linear-gradient(to right bottom, #ffffff 50%, transparent 50%);
`;

const Background = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  margin: 0 auto;
  z-index: -9999;
`;

const DivWarning = errors => {
  console.log("ERRORS", errors);
  if (errors.errors === undefined || errors.errors === null) {
    this.clearFormLogin;
    return <div />;
  } else {
    return (
      <div className="alert alert-danger">Email and password do not match</div>
    );
  }
};

const clearFormLogin = () => {
  this.props.email = null;
  this.props.password = null;
};

const mapStateToProps = state => ({
  ...state.auth,
  errors: state.auth.errors,
  pathname: state.common.path
});

const mapDispatchToProps = dispatch => ({
  onChangeEmail: value =>
    dispatch({ type: UPDATE_FIELD_AUTH, key: "email", value }),
  onChangePassword: value =>
    dispatch({ type: UPDATE_FIELD_AUTH, key: "password", value }),
  onSubmit: (email, password) =>
    dispatch({ type: LOGIN, payload: agent.Auth.login(email, password) }),
  onUnload: () => dispatch({ type: LOGIN_PAGE_UNLOADED }),
  onChangePage: path => dispatch({ type: CHANGE_PAGE, payload: path })
});

class Login extends React.Component {
  constructor() {
    super();
    this.changeEmail = ev => this.props.onChangeEmail(ev.target.value);
    this.changePassword = ev => this.props.onChangePassword(ev.target.value);
    this.submitForm = (email, password) => ev => {
      ev.preventDefault();
      this.props.onSubmit(email, password);
    };
  }

  componentWillMount() {
    this.props.onChangePage("login");
  }

  componentWillUnmount() {
    this.props.onUnload();
  }

  render() {
    const email = this.props.email;
    const password = this.props.password;
    return (
      <div className="row">
        <Helmet>
          <style>{"body { background-color: #179aea }"}</style>
        </Helmet>
        <Background />
        <div
          className="col-sm-8 col-sm-offset-4 col-md-6 col-md-offset-6 text-center"
          style={{ marginTop: "100px" }}
        >
          <form onSubmit={this.submitForm(email, password)}>
            <div className="form-login-login form-group text-center">
              <h1 style={{ fontSize: "42px", marginBottom: "40px" }}>
                Welcome back!
              </h1>
              <DivWarning errors={this.props.errors} />
              <input
                type="email"
                id="userEmail"
                className="form-control input-sm chat-input"
                placeholder="&nbsp;&nbsp;Your email address"
                style={{
                  margin: "auto",
                  marginBottom: "25px",
                  width: "450px",
                  fontSize: "20px"
                }}
                value={email}
                onChange={this.changeEmail}
              />

              <input
                type="password"
                id="userPassword"
                className="form-control input-sm chat-input"
                placeholder="&nbsp;&nbsp;Your password"
                style={{
                  margin: "auto",
                  marginBottom: "25px",
                  width: "450px",
                  fontSize: "20px"
                }}
                value={password}
                onChange={this.changePassword}
              />

              <div className="wrapper" style={{ marginBottom: "25px" }}>
                <span className="group-btn">
                  <button
                    type="submit"
                    className="btn btn-primary btn-md"
                    style={{
                      margin: "auto",
                      width: "450px",
                      fontSize: "20px",
                      borderRadius: "10px"
                    }}
                    disabled={this.props.inProgress}
                  >
                    Log In
                  </button>
                </span>
              </div>

              <h4 style={{ marginLeft: "165px" }}>
                New to transfree? sign up <Link to="register">here</Link>
              </h4>
            </div>
          </form>
        </div>
      </div>
    );
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Login);
