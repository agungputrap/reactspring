import React from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import { LOGOUT } from "../constants/actionTypes";

var styles = {
  homeNav: {
    fontFamily: "Roboto",
    color: "white"
  },
  promoNav: {
    fontFamily: "Roboto",
    color: "#1e2b6f"
  },
  dashboardNav: {
    fontFamily: "Roboto",
    color: "#233685"
  },
  homeNavPromo: {
    fontFamily: "Roboto",
    color: "white",
    borderRadius: "10px",
    backgroundColor: "#ffbb48",
    paddingTop: "5px",
    paddingBottom: "5px",
    marginTop: "10px"
    //paddingLeft: "10px",
    //paddingRight: "10px"
  },
  loggedInUser: {
    backgroundColor: "#3d54be",
    color: "#ffffff",
    width: "75px",
    border: "none",
    borderRadius: "0px",
    fontFamily: "'Open Sans', sans-serif",
    fontSize: "20px"
  }
};

const Bottom = styled.div`
  width: 100%;
  height: 128px;
  background: linear-gradient(to right bottom, #ffffff 50%, transparent 50%);
`;

const mapStateToProps = state => ({
  ...state.auth,
  pathname: state.common.path
});

const mapDispatchToProps = dispatch => ({
  onClickLogout: () => dispatch({ type: LOGOUT })
});

const LoggedOutView = props => {
  if (
    !props.currentUser &&
    props.path !== "login" &&
    props.path !== "register" &&
    props.path !== "promo"
  ) {
    return (
      <ul className="nav navbar-nav pull-right">
        <li className="nav-item">
          <Link to="/contactus" className="nav-link" style={styles.homeNav}>
            Contact Us
          </Link>
        </li>

        <li className="nav-item">
          <Link to="/register" className="nav-link" style={styles.homeNav}>
            Sign up
          </Link>
        </li>

        <li className="nav-item">
          <Link to="/login" className="nav-link" style={styles.homeNav}>
            Sign in
          </Link>
        </li>

        <li className="nav-item">
          <Link
            to="/promo"
            // onClick={props.onClickPromoHeader}
            className="nav-link"
            style={styles.homeNavPromo}
          >
            Promo
          </Link>
        </li>
      </ul>
    );
  } else if (!props.currentUser && props.path === "login") {
    return (
      <Bottom>
        <Helmet>
          <style>{".navbar { margin: 0 }"}</style>
        </Helmet>
        <Link to="/">
          <img
            src="/img/logo.png"
            alt="transfree logo"
            style={{
              width: "175px",
              marginTop: "40px",
              marginLeft: "15px"
            }}
          />
        </Link>
      </Bottom>
    );
  } else if (!props.currentUser && props.path === "register") {
    return (
      <div>
        <div className="navbar-header">
          <Link to="/" className="navbar-brand">
            <img
              src="/img/logo.png"
              alt="transfree logo"
              style={{
                height: "inherit"
              }}
            />
          </Link>
        </div>
        <ul
          className="nav navbar-nav navbar-right"
          style={{ marginRight: "75px" }}
        >
          <li>
            <span style={{ fontSize: "24px", lineHeight: "75px" }}>
              Add Account
            </span>
          </li>
        </ul>
      </div>
    );
  } else if (!props.currentUser && props.path === "promo") {
    return (
      <div>
        <div className="navbar-header">
          <Link to="/" className="navbar-brand">
            <img
              src="/img/logo.png"
              alt="transfree logo"
              style={{
                height: "inherit"
              }}
            />
          </Link>
        </div>
        <ul className="nav navbar-nav pull-right">
          <Helmet>
            <style>
              {".navbar .navbar-default {background-color: #ffffff}"}
            </style>
          </Helmet>
          <li className="nav-item">
            <Link to="/contactus" className="nav-link" style={styles.promoNav}>
              Contact Us
            </Link>
          </li>

          <li className="nav-item">
            <Link to="/register" className="nav-link" style={styles.promoNav}>
              Sign up
            </Link>
          </li>

          <li className="nav-item">
            <Link to="/login" className="nav-link" style={styles.promoNav}>
              Sign in
            </Link>
          </li>

          <li className="nav-item">
            <Link
              to="/promo"
              // onClick={props.onClickPromoHeader}
              className="nav-link"
              style={styles.homeNavPromo}
            >
              Promo
            </Link>
          </li>
        </ul>
      </div>
    );
  }
  return null;
};

const LoggedInView = props => {
  if (!props.error && props.currentUser && props.path === "home") {
    return (
      <ul className="nav navbar-nav pull-right">
        <li className="nav-item">
          <Link to="/" className="nav-link" style={styles.homeNav}>
            Home
          </Link>
        </li>

        <li className="nav-item dropdown">
          <a
            id="dropdownMenu1"
            className="dropdown-toggle"
            data-toggle="dropdown"
            role="button"
            aria-haspopup="true"
            aria-expanded="false"
            style={styles.homeNavPromo}
          >
            {props.currentUser.username} <span className="caret" />
          </a>
          <ul
            className="dropdown-menu dropdown-menu-right"
            aria-labelledby="dropdownMenu1"
          >
            <li>
              {/* <Link to={`/@${props.currentUser.username}`} className="nav-link">
                Dashboard
              </Link> */}
              <Link to="/dashboard" className="nav-link">
                Dashboard
              </Link>
            </li>
            <li role="separator" className="divider" />
            <li>
              <a className="nav-link" onClick={props.onClickLogout}>
                Logout
              </a>
            </li>
          </ul>
        </li>
      </ul>
    );
  } else if (
    !props.error &&
    props.currentUser &&
    (props.path === "dashboard" || props.path === "promo")
  ) {
    return (
      <div>
        <div className="navbar-header">
          <Link to="/" className="navbar-brand">
            <img
              src="/img/logo.png"
              alt="transfree logo"
              style={{
                height: "inherit"
              }}
            />
          </Link>
        </div>
        <ul className="nav navbar-nav pull-right">
          <Helmet>
            <style>
              {".navbar .navbar-default {background-color: #233685}"}
            </style>
          </Helmet>

          <li className="nav-item dropdown">
            <a
              id="dropdownMenu1"
              className="dropdown-toggle"
              data-toggle="dropdown"
              role="button"
              aria-haspopup="true"
              aria-expanded="false"
              style={styles.homeNavPromo}
            >
              {props.currentUser.username} <span className="caret" />
            </a>
            <ul
              className="dropdown-menu dropdown-menu-right"
              aria-labelledby="dropdownMenu1"
            >
              <li>
                {/* <Link to={`/@${props.currentUser.username}`} className="nav-link">
                Dashboard
              </Link> */}
                <Link to="/dashboard" className="nav-link">
                  Dashboard
                </Link>
              </li>
              <li role="separator" className="divider" />
              <li>
                <a className="nav-link" onClick={props.onClickLogout}>
                  Logout
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    );
  }

  return null;
};

const Navbar = styled.nav`
  background-color: transparent;
  border-color: transparent;
  font-size: 18px;
  margin: 8px;
`;

const NavbarRegister = styled.nav`
  background-color: #ffffff;
  border-color: transparent;
  font-size: 18px;
  height: 75px;
  border-bottom: 5px solid #a8aaa7;
`;

const NavbarDashboard = styled.nav`
  background-color: #ffffff;
  border-color: #a5afb5;
  font-size: 18px;
  height: 75px;
  padding: 10px 10px;
`;

class HeaderTes extends React.Component {
  constructor() {
    super();
    this.onClickLogout = () => ev => {
      ev.preventDefault();
      this.props.onClickLogout();
    };
  }
  componentWillMount() {
    //console.log("USER : ", this.props.currentUser);
  }

  clickedHeaderPromo(event) {
    event.preventDefault();
    window.open("https://www.transfree.id/gbp-idr", "_blank");
  }

  render() {
    if (this.props.pathname === "register") {
      return (
        <NavbarRegister className="navbar navbar-default" role="navigation">
          <LoggedOutView
            currentUser={this.props.currentUser}
            path={this.props.pathname}
            error={this.props.error}
          />
          <LoggedInView
            currentUser={this.props.currentUser}
            path={this.props.pathname}
            error={this.props.error}
            onClickLogout={this.props.onClickLogout}
          />
        </NavbarRegister>
      );
    } else if (
      this.props.pathname === "dashboard" ||
      this.props.pathname === "promo"
    ) {
      return (
        <NavbarDashboard className="navbar navbar-default" role="navigation">
          <LoggedOutView
            currentUser={this.props.currentUser}
            path={this.props.pathname}
            error={this.props.error}
          />
          <LoggedInView
            currentUser={this.props.currentUser}
            path={this.props.pathname}
            error={this.props.error}
            onClickLogout={this.props.onClickLogout}
          />
        </NavbarDashboard>
      );
    }
    return (
      <Navbar className="navbar navbar-default" role="navigation">
        <LoggedOutView
          currentUser={this.props.currentUser}
          path={this.props.pathname}
          error={this.props.error}
          onClickPromoHeader={this.clickedHeaderPromo}
        />
        <LoggedInView
          currentUser={this.props.currentUser}
          path={this.props.pathname}
          error={this.props.error}
          onClickLogout={this.props.onClickLogout}
        />
      </Navbar>
    );
  }
}

//export default HeaderTes;
export default connect(
  mapStateToProps,
  mapDispatchToProps
)(HeaderTes);
