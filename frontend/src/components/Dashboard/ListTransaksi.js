import React from "react";

const ListTransaksi = props => {
  const transaksi = props => {
    if (props.transaksi) {
      return props.transaksi.map((name, index) => {
        return (
          <tr key={index}>
            <td>{index + 1}</td>
            <td>{name.waktuTransaksiStr}</td>
            <td>{name.namaPenerima}</td>
            <td>{name.nominalIdr}</td>
            <td>{name.status}</td>
          </tr>
        );
      });
    }
    return <tr />;
  };

  return <tbody>{transaksi(props)}</tbody>;
};

export default ListTransaksi;
