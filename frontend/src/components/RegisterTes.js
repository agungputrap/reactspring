import { Link } from "react-router-dom";
import ListErrors from "./ListErrors";
import React from "react";
import agent from "../agent";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import {
  UPDATE_FIELD_AUTH,
  REGISTER,
  REGISTER_PAGE_UNLOADED,
  CHANGE_PAGE
} from "../constants/actionTypes";

var styles = {
  formRegister: {
    fontFamily: `'Roboto', sans-serif`,
    paddingTop: "10px",
    paddingBottom: "20px",
    paddingLeft: "20px,",
    paddingRight: "20px",
    marginTop: "75px",
    marginLeft: "45px"
  },
  btnAddBack: {
    width: "135px",
    height: "45px"
  }
};

const mapStateToProps = state => ({
  ...state.auth,
  pathname: state.common.path
});

const mapDispatchToProps = dispatch => ({
  onChangeEmail: value =>
    dispatch({ type: UPDATE_FIELD_AUTH, key: "email", value }),
  onChangePassword: value =>
    dispatch({ type: UPDATE_FIELD_AUTH, key: "password", value }),
  onChangeUsername: value =>
    dispatch({ type: UPDATE_FIELD_AUTH, key: "username", value }),
  onSubmit: user => {
    const payload = agent.Auth.register(user);
    dispatch({ type: REGISTER, payload });
  },
  onUnload: () => dispatch({ type: REGISTER_PAGE_UNLOADED }),
  onChangePage: path => dispatch({ type: CHANGE_PAGE, payload: path }),
  onChangeFormField: (key, value) =>
    dispatch({ type: UPDATE_FIELD_AUTH, key, value })
});

class Register extends React.Component {
  constructor() {
    super();
    this.submitForm = (
      fullname,
      username,
      tanggalLahir,
      ktpId,
      email,
      password,
      confirmPassword
    ) => ev => {
      const user = {
        fullname,
        username,
        tanggalLahir,
        ktpId,
        email,
        password,
        confirmPassword
      };
      ev.preventDefault();
      this.props.onSubmit(user);
    };
    this.changeFormField = (key, value) =>
      this.props.onChangeFormField(key, value);
    this.state = {
      formErrors: {
        fullname: "",
        username: "",
        tanggalLahir: "",
        ktpId: "",
        email: "",
        password: "",
        confirmPassword: ""
      }
    };
  }

  validateForm() {
    console.log("object", this.state.username);
  }

  componentWillMount() {
    this.props.onChangePage("register");
  }

  componentWillUnmount() {
    this.props.onUnload();
  }

  render() {
    const email = this.props.email;
    const password = this.props.password;
    const confirmPassword = this.props.confirmPassword;
    const username = this.props.username;
    const fullname = this.props.fullname;
    const tanggalLahir = this.props.tanggalLahir;
    const ktpId = this.props.ktpId;

    return (
      <div className="row">
        <Helmet>
          <style>{"body { background-color: #cad8ff }"}</style>
        </Helmet>

        <form
          onSubmit={this.submitForm(
            fullname,
            username,
            tanggalLahir,
            ktpId,
            email,
            password,
            confirmPassword
          )}
        >
          <div className="col-sm-6">
            <div className="form-signup" style={styles.formRegister}>
              <input
                name="title"
                placeholder="Mr/Mrs/Ms"
                className="form-control"
                type="text"
                style={{ marginBottom: "25px", width: "475px" }}
              />
              <input
                name="fullname"
                placeholder="Full Name"
                className="form-control"
                type="text"
                style={{ marginBottom: "25px", width: "475px" }}
                value={this.fullname}
                onChange={ev =>
                  this.changeFormField("fullname", ev.target.value)
                }
              />
              <input
                name="tanggalLahir"
                placeholder="DD/MM/YYYY"
                className="form-control"
                type="date"
                style={{ marginBottom: "25px", width: "475px" }}
                value={this.tanggalLahir}
                onChange={ev =>
                  this.changeFormField("tanggalLahir", ev.target.value)
                }
              />
              <input
                name="ktpId"
                placeholder="ID Number"
                className="form-control"
                type="text"
                style={{ marginBottom: "25px", width: "475px" }}
                value={this.ktpId}
                onChange={ev => this.changeFormField("ktpId", ev.target.value)}
              />
              <input
                name="iban"
                placeholder="IBAN or Short Code (if any)"
                className="form-control"
                type="text"
                style={{ marginBottom: "25px", width: "475px" }}
                value={this.shortCode}
                onChange={ev =>
                  this.changeFormField("shortCode", ev.target.value)
                }
              />
            </div>
          </div>
          <div className="col-sm-6">
            <div className="form-signup" style={styles.formRegister}>
              <input
                name="email"
                placeholder="email"
                className="form-control"
                type="text"
                style={{ marginBottom: "25px", width: "475px" }}
                value={this.email}
                onChange={ev => this.changeFormField("email", ev.target.value)}
              />
              <input
                name="username"
                placeholder="Username"
                className="form-control"
                type="text"
                style={{ marginBottom: "25px", width: "475px" }}
                value={this.username}
                onChange={ev =>
                  this.changeFormField("username", ev.target.value)
                }
              />
              <input
                name="password"
                placeholder="Password"
                className="form-control"
                type="password"
                style={{ marginBottom: "25px", width: "475px" }}
                value={this.password}
                onChange={ev =>
                  this.changeFormField("password", ev.target.value)
                }
              />
              <input
                name="confirm"
                placeholder="Confirm Password"
                className="form-control"
                type="password"
                style={{ marginBottom: "25px", width: "475px" }}
                value={this.confirmPassword}
                onChange={ev =>
                  this.changeFormField("confirmPassword", ev.target.value)
                }
              />
              <div
                className="form-actions text-center"
                style={{ marginTop: "40px", marginBottom: "55px" }}
              >
                <Link
                  to="/"
                  className="btn btn-danger btn-lg"
                  type="button"
                  style={styles.btnAddBack}
                >
                  Back
                </Link>
                <button
                  className="btn btn-success btn-lg"
                  type="submit"
                  style={styles.btnAddBack}
                >
                  Add
                </button>
              </div>
            </div>
          </div>
        </form>
      </div>
    );
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Register);
