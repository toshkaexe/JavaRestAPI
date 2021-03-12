import React from "react";

class Utils extends React.Component {
  isValueNotEmpty(text) {
    if (text.length === 0) {
      return false;
    } else {
      return true;
    }
  }

  isNotEmptyEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (re.test(String(email).toLowerCase())) {
      return true;
    } else {
      return false;
    }
  }
}
export default new Utils();
