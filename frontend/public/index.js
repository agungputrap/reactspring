import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import React from "react";
import { store, history } from "./store";

import { Route, Switch } from "react-router-dom";
import { ConnectedRouter } from "react-router-redux";

import App from "./components/App";
import AppTes from "./components/AppTes";
import AppOther from "./components/AppOther";

ReactDOM.render(
  <Provider store={store}>
    <ConnectedRouter history={history}>
      <Switch>
        <Route path="/" component={AppOther} />
      </Switch>
    </ConnectedRouter>
  </Provider>,

  document.getElementById("root")
);
