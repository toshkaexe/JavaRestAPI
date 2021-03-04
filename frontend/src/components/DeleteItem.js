import React, { Component } from "react";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";

import DialogTitle from "@material-ui/core/DialogTitle";

export class DeleteItem extends Component {
  constructor(props) {
    super(props);
    this.state = {
      open: false,
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
  };
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
              Add User
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}
