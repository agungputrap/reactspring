import { HOME_PAGE_LOADED, HOME_PAGE_UNLOADED } from "../constants/actionTypes";

export default (state = {}, action) => {
  switch (action.type) {
    case HOME_PAGE_LOADED:
      console.log("HOME", action.payload);
      return {
        ...state,
        token: action.token || null,
        appLoaded: true,
        currentUser: action.payload ? action.payload : null,
        path: action.payload ? action.payload.pathname : null
      };
    case HOME_PAGE_UNLOADED:
      return {};
    default:
      return state;
  }
};
