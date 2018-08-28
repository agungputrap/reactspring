import React from "react";
import styled from "styled-components";

const Navbar = styled.nav`
  background-color: transparent;
  border-color: transparent;
  font-size: 18px;
  margin: 8px;
`;

const ImgSmall = styled.img`
  height: 90px;
  margin-top: 50px;
  margin-left: 100px;
`;

const TextSmall = styled.span`
  margin-left: 120px;
  font-family: "Open Sans", sans-serif;
  font-size: 15px;
`;

const BackgroundDiv = styled.div`
  background-color: #233685;
  margin: 0;
  position: relative;
  top: -8px;
`;

const ImgBack = styled.img`
  width: 75%;
  position: absolute;
  top: 0;
  left: 0;
  z-index: -9999;
`;

class AppTes extends React.Component {
  render() {
    return (
      <BackgroundDiv>
        <ImgBack src="/img/circle.svg" />
        <Navbar className="navbar navbar-default" role="navigation">
          <ul className="nav navbar-nav navbar-right">
            <li>
              <a href="#">Contact Us</a>
            </li>
            <li>
              <a href="signup.html">Sign Up</a>
            </li>
            <li>
              <a href="login.PushNotificationIOS.getMessage()l">Log in</a>
            </li>
            <li>
              <a href="#">
                <span>Promo</span>
              </a>
            </li>
          </ul>
        </Navbar>
        <a href="homepage.html">
          <ImgSmall
            src="/img/logo.png"
            className="img-responsive"
            alt="transfree logo"
          />
        </a>
        <TextSmall>
          Make international transfer feels like local transfer
        </TextSmall>
      </BackgroundDiv>
    );
  }
}

export default AppTes;
