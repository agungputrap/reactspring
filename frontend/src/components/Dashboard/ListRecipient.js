import React from "react";

const ListRecipient = props => {
  console.log("REC", props);
  const Recipient = ({ recipients }) => {
    if (recipients.length <= 0) {
      return;
    } else {
      return recipients.map((name, index) => {
        return (
          <option key={index} value={name.value}>
            {name.text}
          </option>
        );
      });
    }
  };

  return (
    <select className="form-control group-send" value={props.recipient}>
      <option value="" disabled>
        --Recipient--
      </option>
      {Recipient(props)}
    </select>
  );
};

export default ListRecipient;
