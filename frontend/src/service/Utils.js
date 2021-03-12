import React from "react";

class Utils extends React.Component {
  isValueNotEmpty(text) {
    if (text.length === 0) {
      console.log("Please enter name");
      return false;
    } else {
      return true;
    }
  }

  isNotEmptyEmail(text) {
    if (text.length === 0) {
      console.log("Please enter email");
      return false;
    } else {
      return true;
    }
  }

  validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
  }
}
export default new Utils();
