import React, { Component } from "react";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import TextField from "@material-ui/core/TextField";

import DialogTitle from "@material-ui/core/DialogTitle";

export class EditItem extends Component {
  constructor(props) {
    super(props);
    this.state = {
      open: false,
      id: props.id,
      setFirstName:  props.firstName, 
      setLastName:  props.lastName,
      setEmail:  props.email
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
    this.setState({ open: false,
      
      setFirstName:  this.state.getFirstName, 
      secondName:  this.state.getLastName,
      setEmail:  this.state.getEmail

     });
     

    console.log("close and save user");


    console.log(
      "User: [firstName: " +
        this.state.setFirstName +
        ", secondName: " +
        this.state.setLastName+
        ", email: " +
        this.state.setEmail +
        "]"
    );




    
    
  };



  getFirstName = (event) => {
    this.setState({ setFirstName: event.target.value });
  };
  getSecoldName = (event) => {
    this.setState({ setLastName: event.target.value });
  };
  getEmail = (event) => {
    this.setState({ setEmail: event.target.value });
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
              defaultValue={this.state.setFirstName}              
            />
          <TextField
              autoFocus
              margin="dense"
              label="Last Name"
              type="text"
              onChange={this.setLastName}
              defaultValue={this.state.setLastName}              
            />
                      <TextField
              autoFocus
              margin="dense"
              label="Email"
              type="text"
              onChange={this.setEmailName}           
              defaultValue={this.state.setEmail}              
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
