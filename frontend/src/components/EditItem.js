import React, { Component } from "react";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";

import DialogTitle from "@material-ui/core/DialogTitle";

export class EditItem extends Component {
  constructor(props) {
    super(props);
    this.state = {
      open: false,
    };
    this.handleSaveAndClose = this.handleSaveAndClose.bind(this);
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
  handleSaveAndClose = (event) => {
    this.setState({ open: false });
    console.log("close and delete");
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
          <DialogActions>
            <Button onClick={this.handleClose} color="primary">
              Cancel
            </Button>
            <Button onClick={this.handleSaveAndClose} color="primary">
              Save and Close
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}
