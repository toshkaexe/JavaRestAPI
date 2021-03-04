import React from "react";

import "bootstrap/dist/css/bootstrap.min.css";

import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";

//const USERS_REST_API_URL = 'http://jsonplaceholder.typicode.com/users';
//const USERS_REST_API_URL = "http://localhost:8080/users";

export default class AddNewUser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      open: false,

      firstname: "",
      secondname: "",
      email: "",
    };
    this.handleClickOpen = this.handleClickOpen.bind(this);
    this.handleClose = this.handleClose.bind(this);
    this.handleCloseAndSaveUser = this.handleCloseAndSaveUser.bind(this);
    this.getFirstName = this.getFirstName.bind(this);
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
  };

  getFirstName = (event) => {
    this.setState({ firstname: event.target.value });
  };
  getSecoldName = (event) => {
    this.setState({ secondname: event.target.value });
  };
  getEmail = (event) => {
    this.setState({ email: event.target.value });
  };

  render() {
    return (
      <div className="text-left">
        <Button
          variant="outlined"
          color="primary"
          onClick={this.handleClickOpen}
        > Create new user
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
              onChange={this.getSecoldName}
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
