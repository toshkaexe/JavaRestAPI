import React, { Component } from "react";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";

import DialogTitle from "@material-ui/core/DialogTitle";
import axios from "axios";

const USERS_REST_API_URL = "http://localhost:8085/users/";

export class DeleteItem extends Component {
  constructor(props) {
    super(props);
    this.state = {
      open: false,
      id: props.id,
    };
    this.handleDeleteAndClose = this.handleDeleteAndClose.bind(this);
    this.handleClose = this.handleClose.bind(this);
    this.handleClickOpen = this.handleClickOpen.bind(this);
  }

  handleClickOpen = (event) => {
    this.setState({ open: true });
    console.log("closed1");
  };

  handleClose = (event) => {
    this.setState({ open: false });
    console.log("closed");
  };
  handleDeleteAndClose = (event) => {
    this.setState({ open: false });
    console.log("close and delete");
    console.log("DELELTED User: [id: " + this.state.id + "]");

    event.preventDefault();
    console.log(this.state);

    axios
      .delete(USERS_REST_API_URL + this.state.id, {})
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

  render() {
    return (
      <div className="text-left">
        <Button
          variant="contained"
          color="secondary"
          onClick={this.handleClickOpen}
        >
          Delete
        </Button>

        <Dialog open={this.state.open} onClose={this.handleClose}>
          <DialogTitle> Delete User </DialogTitle>
          <DialogActions>
            <Button onClick={this.handleClose} color="primary">
              Cancel
            </Button>
            <Button onClick={this.handleDeleteAndClose} color="primary">
              Delete User
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}
