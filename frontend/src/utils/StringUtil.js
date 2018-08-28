export const dateIndo = [
  "Januari",
  "Februari",
  "Maret",
  "April",
  "Mei",
  "Juni",
  "Juli",
  "Agustus",
  "September",
  "Oktober",
  "November",
  "Desember"
];

export const MsToDateIndo = ms => {
  if (ms === undefined || ms === null || ms === "") return "";
  var tanggal = new Date(ms);
  console.log("TANGGAL", tanggal.getMonth());
  let res =
    tanggal.getDate() +
    " " +
    dateIndo[tanggal.getMonth()] +
    " " +
    tanggal.getFullYear();

  return res;
};
