import { filter } from "lodash";

const ListKurensi = [
  { code: "IDR", symbol: "Rp." },
  { code: "USD", symbol: "$" },
  { code: "EUR", symbol: "€" },
  { code: "GBP", symbol: "£" }
];

export const GetCurrencySymbol = code => {
  switch (code) {
    case "IDR":
      return "Rp.";
      break;
    case "USD":
      return "$";
      break;
    case "EUR":
      return "€";
      break;
    case "GBP":
      return "£";
      break;
    default:
      return "";
  }
};

export const GetFormattedMoney = money => {
  if (money === undefined || money === null || money === "") return money;
  return money.toLocaleString(
    "id-ID",
    { minimumFractionDigits: 2 }
  );
};

export const GetDiscountedKurs = rate => {
  let discount = 0.6 / 100;
  if (rate === undefined || rate === null || rate === "") return rate;
  return rate * discount;
};
