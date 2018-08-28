import {
  APP_LOAD,
  REDIRECT,
  LOGOUT,
  ARTICLE_SUBMITTED,
  SETTINGS_SAVED,
  LOGIN,
  REGISTER,
  DELETE_ARTICLE,
  ARTICLE_PAGE_UNLOADED,
  EDITOR_PAGE_UNLOADED,
  HOME_PAGE_UNLOADED,
  PROFILE_PAGE_UNLOADED,
  PROFILE_FAVORITES_PAGE_UNLOADED,
  SETTINGS_PAGE_UNLOADED,
  LOGIN_PAGE_UNLOADED,
  REGISTER_PAGE_UNLOADED,
  CHANGE_PAGE,
  DASHBOARD_PAGE_UNLOAD,
  TRANSACTION_PAGE_LOADED,
  ADD_RECIPIENT,
  SENT_MONEY,
  BUY_PROMO
} from "../constants/actionTypes";

const defaultState = {
  appName: "Transfree",
  token: null,
  viewChangeCounter: 0,
  backgroundColor: "#233685",
  path: null
};

export default (state = defaultState, action) => {
  switch (action.type) {
    case APP_LOAD:
      return {
        ...state,
        error: action.error ? true : false,
        token: action.token || null,
        appLoaded: true,
        currentUser: action.payload ? action.payload : null,
        transactions: {
          idPengguna: "",
          totalTransaksiIdr: 0,
          totalTransaksiGbp: 0,
          transaksi: [
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
        }
      };
    case REDIRECT:
      return { ...state, redirectTo: null };
    case LOGOUT:
      return { ...state, redirectTo: "/", token: null, currentUser: null };
    case ARTICLE_SUBMITTED:
      const redirectUrl = `/article/${action.payload.article.slug}`;
      return { ...state, redirectTo: redirectUrl };
    case SETTINGS_SAVED:
      return {
        ...state,
        redirectTo: action.error ? null : "/",
        currentUser: action.error ? null : action.payload.user
      };
    case LOGIN:
    case REGISTER:
      return {
        ...state,
        redirectTo: action.error ? null : "/",
        token: action.error ? null : action.payload.idToken,
        currentUser: action.error ? null : action.payload.pengguna
      };
    case DELETE_ARTICLE:
      return { ...state, redirectTo: "/" };
    case ARTICLE_PAGE_UNLOADED:
    case EDITOR_PAGE_UNLOADED:
    case HOME_PAGE_UNLOADED:
    case PROFILE_PAGE_UNLOADED:
    case PROFILE_FAVORITES_PAGE_UNLOADED:
    case SETTINGS_PAGE_UNLOADED:
    case LOGIN_PAGE_UNLOADED:
    case REGISTER_PAGE_UNLOADED:
      return { ...state, viewChangeCounter: state.viewChangeCounter + 1 };
    case CHANGE_PAGE:
      return {
        ...state,
        path: action.payload
      };
    case DASHBOARD_PAGE_UNLOAD:
      return { ...state };
    case TRANSACTION_PAGE_LOADED:
      return {
        ...state,
        transactions: action.payload ? action.payload : null
      };
    case ADD_RECIPIENT:
      return {
        ...state,
        redirectTo: "/dashboard"
      };
    case SENT_MONEY:
      return {
        ...state,
        promoBought: null,
        redirectTo: "/dashboard"
      };
    case BUY_PROMO:
      return {
        ...state,
        promoBought: action.payload ? action.payload : null
      };
    default:
      return state;
  }
};
