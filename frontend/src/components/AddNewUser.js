import React from "react";

import "bootstrap/dist/css/bootstrap.min.css";

import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import axios from "axios";

const USERS_REST_API_URL = "http://localhost:8085/users";

export default class AddNewUser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      open: false,
      firstname: "",
      lastName: "",
      email: "",
    };
    this.handleClickOpen = this.handleClickOpen.bind(this);
    this.handleClose = this.handleClose.bind(this);
    this.handleCloseAndSaveUser = this.handleCloseAndSaveUser.bind(this);
  }

  handleClickOpen = (event) => {
    this.setState({ open: true });
    console.log("opened");
  };
  handleClose = (event) => {
    this.setState({ open: false });
    console.log("closed");
  };

  handleCloseAndSaveUser = (event) => {
    this.setState({ open: false });
    console.log("close and save user");
    console.log(
      "User: [firstName: " +
        this.state.firstname +
        ", secondName: " +
        this.state.secondname +
        ", email: " +
        this.state.email +
        "]"
    );
    event.preventDefault();
    console.log(this.state);
    console.log("id1=" + this.generateId());

    axios
      .post(USERS_REST_API_URL, {
        id: this.generateId(),
        firstName: this.state.firstname,
        lastName: this.state.secondname,
        email: this.state.email,
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console(error);
      });
   // this.refreshPage();
  };

  getFirstName = (event) => {
    this.setState({ firstname: event.target.value });
  };
  getSecondName = (event) => {
    this.setState({ secondname: event.target.value });
  };
  getEmail = (event) => {
    this.setState({ email: event.target.value });
  };

  refreshPage() {
    window.location.reload(false);
  }

  generateId() {
    var date = new Date();
    var components = [
      date.getYear(),
      date.getMonth(),
      date.getDate(),
      date.getHours(),
      date.getMinutes(),
      date.getSeconds(),
      date.getMilliseconds(),
    ];

    return components.join("");
  }

  render() {
    return (
      <div className="text-left">
        <Button
          variant="contained"
          color="primary"
          onClick={this.handleClickOpen}
        >
          Create new user
        </Button>
        <Dialog open={this.state.open} onClose={this.handleClose}>
          <DialogTitle id="form-dialog-title">Add new User</DialogTitle>

          <DialogContent>
            <TextField
              autoFocus
              margin="dense"
              label="First Name"
              type="text"
              //   onChange={(event) => setFirstName(event.target.value)}
              onChange={this.getFirstName}
            />
            <br />
            <TextField
              autoFocus
              margin="dense"
              label="Second Name"
              type="text"
              //    onChange={(event) => setSecondName(event.target.value)}
              onChange={this.getSecondName}
            />
            <br />
            <TextField
              autoFocus
              margin="dense"
              label="Email Address"
              type="email"
              onChange={this.getEmail}
              //onChange={(event) => setEmail(event.target.value)}
            />
          </DialogContent>
          <DialogActions>
            <Button onClick={this.handleClose} color="primary">
              Cancel
            </Button>
            <Button onClick={this.handleCloseAndSaveUser} color="primary">
              Add User
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}
