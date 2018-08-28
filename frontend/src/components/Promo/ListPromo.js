import React, { Component } from "react";
import { GetCurrencySymbol, GetFormattedMoney } from "./../../utils/KursUtil";

class ListPromo extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  onClickBuyPromo = data => {
    this.props.buyPromo(data);
  };

  render() {
    const promo = props => {
      if (props.promo) {
        return props.promo.map((item, index) => {
          return (
            <div className="col-sm-3 col-md-3" key={item.id}>
              <div className="thumbnail">
                <div className="caption">
                  <h3 style={{ textAlign: "center" }}>{item.nama}</h3>
                  <p>
                    {"Currency Rate " +
                      GetCurrencySymbol(item.kursKe) +
                      "" +
                      GetFormattedMoney(item.kurs)}
                  </p>
                  <br />
                  <p>
                    <a>Get Rp 25,000 with a referral code</a>
                  </p>
                  <h4 style={{ textAlign: "center" }}>
                    {"Flexible Amount Below " +
                      GetCurrencySymbol(item.kursDari) +
                      "" +
                      GetFormattedMoney(item.nominal)}
                  </h4>
                  <p style={{ textAlign: "center" }}>
                    <button
                      id={`btn${item.id}`}
                      className="btn btn-primary"
                      onClick={this.onClickBuyPromo.bind(this, item.id)}
                    >
                      Buy
                    </button>
                  </p>
                </div>
                <div style={{ backgroundColor: "#F17424" }}>
                  <h3 style={{ textAlign: "center", color: "#ffffff" }}>
                    Flexible
                  </h3>
                </div>
              </div>
            </div>
          );
        });
      }
      return <tr />;
    };

    return <div>{promo(this.props)}</div>;
  }
}

export default ListPromo;
