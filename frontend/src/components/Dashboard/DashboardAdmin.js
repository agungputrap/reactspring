import React, { Component } from "react";
import { connect } from "react-redux";
import { Helmet } from "react-helmet";
import { store } from "../../store";
import { push } from "react-router-redux";
import agent from "../../agent";
import ListTransaksi from "./ListTransaksi";
import { Link } from "react-router-dom";
import { Table } from "reactstrap";
import BootstrapTable from "react-bootstrap-table-next";
import cellEditFactory, { Type } from "react-bootstrap-table2-editor";
import ListTransaksiAdmin from "./ListTransaksiAdmin";
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

const columns = [
  {
    dataField: "rowIndex",
    text: "No",
    editable: false
  },
  {
    dataField: "id",
    text: "ID",
    editable: false,
    visible: false
  },
  {
    dataField: "waktuTransaksiStr",
    text: "Date",
    editable: false
  },
  {
    dataField: "namaPenerima",
    text: "Recipient",
    editable: false
  },
  {
    dataField: "nominalIdr",
    text: "Amount",
    editable: false
  },
  {
    dataField: "status",
    text: "Status",
    editor: {
      type: Type.SELECT,
      options: [
        {
          value: "SUBMIT",
          label: "SUBMIT"
        },
        {
          value: "PROCCESS",
          label: "PROCCESS"
        },
        {
          value: "NOT APPROVED",
          label: "NOT APPROVED"
        },
        {
          value: "DONE",
          label: "DONE"
        }
      ]
    }
  }
];

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

class DashboardAdmin extends Component {
  constructor() {
    super();
    this.state = {
      transaksis: [
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
    agent.Admin.transactions().then(res => {
      this.setState({ transaksis: res });
    });
  }
  changeStatusTransaction = (newValue, idTrans) => {
    agent.Transaksi.changeTransactionStatus(newValue, idTrans).then(res => {
      if (res && res.code === 200) {
        console.log("SUCCESS");
        store.dispatch(push("/"));
        this.props.onRedirect();
      }
    });
  };

  render() {
    return (
      <div className="container">
        <div className="panel panel-primary" style={{ background: "#ffffff" }}>
          <Helmet>
            <style>{"body { background-color: #d3dbfd }"}</style>
          </Helmet>
          <div className="panel-heading">
            <h4>DASHBOARD ADMIN</h4>
          </div>
          <div className="panel-body">
            <div>
              <div style={{ textAlign: "center" }}>
                <h2>Transactions</h2>
              </div>
              <div>
                <Table dark>
                  <thead>
                    <tr>
                      <th style={{ textAlign: "center" }}>No.</th>
                      <th style={{ textAlign: "center" }}>Date</th>
                      <th style={{ textAlign: "center" }}>Recipient</th>
                      <th style={{ textAlign: "center" }}>Amount</th>
                      <th style={{ textAlign: "center" }}>Status</th>
                    </tr>
                  </thead>
                  <ListTransaksiAdmin
                    transaksi={this.state.transaksis}
                    changeStatusTransaction={this.changeStatusTransaction}
                  />
                </Table>
                {/* <BootstrapTable
                  remote={{ cellEdit: true }}
                  keyField="id"
                  data={this.state.transaksis}
                  columns={columns}
                  cellEdit={cellEditFactory({
                    mode: "click",
                    blurToSave: true
                  })}
                  onTableChange={onTableChange}
                /> */}
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

const onTableChange = (type, newState) => {
  console.log("type", type);
  console.log("new", newState);
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(DashboardAdmin);
