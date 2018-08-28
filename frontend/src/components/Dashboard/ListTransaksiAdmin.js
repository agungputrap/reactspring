import React, { Component } from "react";
import { filter } from "lodash";
import { GetCurrencySymbol, GetFormattedMoney } from "./../../utils/KursUtil";

class ListTransaksiAdmin extends Component {
  constructor(props) {
    super(props);
    this.state = {
      newValue: 0,
      id: 0
    };
  }

  closeModal() {
    document.getElementById("closeModal").click();
  }

  render() {
    const onClickChangeStatus = (newValue, id) => {
      this.props.changeStatusTransaction(newValue, id);
      this.closeModal();
    };

    const statusbtn = stat => {
      if (stat === "SUBMIT") return "btn btn-primary";
      else if (stat === "PROCCESS") return "btn btn-warning";
      else if (stat === "NOT APPROVED") return "btn btn-danger";
      else return "btn btn-success";
    };

    const transaksi = props => {
      if (props.transaksi) {
        return props.transaksi.map((name, index) => {
          return (
            <tr key={index}>
              <td style={{ textAlign: "center" }}>{index + 1}</td>
              <td>{name.waktuTransaksiStr}</td>
              <td>{name.namaPenerima}</td>
              <td style={{ textAlign: "center" }}>
                {GetCurrencySymbol(name.kursDari) +
                  "" +
                  GetFormattedMoney(name.nominal) +
                  " = " +
                  GetCurrencySymbol(name.kursKe) +
                  "" +
                  GetFormattedMoney(name.nominal * name.kurs)}
              </td>
              <td style={{ textAlign: "center" }}>
                <button
                  className={statusbtn(name.status)}
                  data-toggle="modal"
                  data-target={`#${name.id}`}
                >
                  {name.status}
                </button>
                <div
                  className="modal fade"
                  id={name.id}
                  tabIndex="-1"
                  role="dialog"
                  aria-labelledby="myModalLabel"
                >
                  <div className="modal-dialog" role="document">
                    <div className="modal-content">
                      <div className="modal-header">
                        <button
                          type="button"
                          className="close"
                          data-dismiss="modal"
                          aria-label="Close"
                        >
                          <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 className="modal-title" id="myModalLabel">
                          Transaction
                        </h4>
                      </div>
                      <div className="modal-body">
                        <dl>
                          <dt>Recipient</dt>
                          <dd>
                            <h4>{name.namaPenerima}</h4>
                          </dd>
                          <dt>Amount</dt>
                          <dd>
                            <h4>
                              {GetCurrencySymbol(name.kursDari) +
                                " " +
                                GetFormattedMoney(name.nominal) +
                                " = " +
                                GetCurrencySymbol(name.kursKe) +
                                " " +
                                GetFormattedMoney(name.nominal * name.kurs)}
                            </h4>
                          </dd>
                          <dt>Status</dt>
                          <dd>
                            <select
                              className="form-control"
                              id={`select${name.id}`}
                              value={name.status}
                              onChange={ev => {
                                onClickChangeStatus(ev.target.value, name.id);
                              }}
                            >
                              <option>SUBMIT</option>
                              <option>PROCCESS</option>
                              <option>NOT APPROVED</option>
                              <option>DONE</option>
                            </select>
                          </dd>
                        </dl>
                      </div>
                      <div className="modal-footer">
                        <button
                          type="button"
                          className="btn btn-default"
                          data-dismiss="modal"
                          id="closeModal"
                        >
                          Close
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </td>
            </tr>
          );
        });
      }
      return <tr />;
    };

    return <tbody>{transaksi(this.props)}</tbody>;
  }
}

export default ListTransaksiAdmin;
