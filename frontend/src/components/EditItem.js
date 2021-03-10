import React, { Component } from "react";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import TextField from "@material-ui/core/TextField";

import DialogTitle from "@material-ui/core/DialogTitle";
import axios from "axios";

const USERS_REST_API_URL = "http://localhost:8085/users/";

export class EditItem extends Component {
  constructor(props) {
    super(props);
    this.state = {
      open: false,
      id1: props.id,
      setFirstName1: props.firstName,
      setLastName1: props.lastName,
      setEmail1: props.email,
    };

    this.handleEditedAndClose = this.handleEditedAndClose.bind(this);
    this.handleClose = this.handleClose.bind(this);
    this.handleClickOpen = this.handleClickOpen.bind(this);
  }

  handleClickOpen = (event) => {
    this.setState({ open: true });
    console.log("closed");
  };

  handleClose = (event) => {
    this.setState({ open: false });
    console.log("closed");
  };

  handleEditedAndClose = (event) => {
    this.setState({
      open: false,

      setFirstName1: this.state.setFirstName1,
      secondName1: this.state.setLastName1,
      setEmail1: this.state.setEmail1,
    });

    console.log("close and save user");

    console.log(
      "User: [id: " +
        this.state.id1 +
        ", firstName: " +
        this.state.setFirstName1 +
        ", secondName: " +
        this.state.setLastName1 +
        ", email: " +
        this.state.setEmail1 +
        "]"
    );
    event.preventDefault();
    console.log(this.state);

    axios
      .put(USERS_REST_API_URL + this.state.id1, {
        id: this.state.id1,
        firstName: this.state.setFirstName1,
        lastName: this.state.setLastName1,
        email: this.state.setEmail1,
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console(error);
      });

    this.refreshPage();
  };

  refreshPage() {
    window.location.reload(false);
  }

  setFirstName = (event) => {
    this.setState({ setFirstName1: event.target.value });
  };
  setLastName = (event) => {
    this.setState({ setLastName1: event.target.value });
  };
  setEmail = (event) => {
    this.setState({ setEmail1: event.target.value });
  };

  render() {
    return (
      <div className="text-left">
        <Button
          variant="contained"
          color="primary"
          onClick={this.handleClickOpen}
        >
          Edit
        </Button>

        <Dialog open={this.state.open} onClose={this.handleClose}>
          <DialogTitle> Edit User </DialogTitle>

          <TextField
            autoFocus
            margin="dense"
            label="First Name"
            type="text"
            onChange={this.setFirstName}
            defaultValue={this.state.setFirstName1}
          />
          <TextField
            autoFocus
            margin="dense"
            label="Last Name"
            type="text"
            onChange={this.setLastName}
            defaultValue={this.state.setLastName1}
          />
          <TextField
            autoFocus
            margin="dense"
            label="Email"
            type="text"
            onChange={this.setEmail}
            defaultValue={this.state.setEmail1}
          />
          <DialogActions>
            <Button onClick={this.handleClose} color="primary">
              Cancel
            </Button>
            <Button onClick={this.handleEditedAndClose} color="primary">
              Save and Close
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}
