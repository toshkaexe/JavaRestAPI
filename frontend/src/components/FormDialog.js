import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";

import DialogTitle from "@material-ui/core/DialogTitle";

function FormDialog() {
  const [open, setOpen] = React.useState(false);
  const [firstname, setFirstName] = React.useState("");
  const [secondName, setSecondName] = React.useState("");
  const [email, setEmail] = React.useState("");

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
    console.log("close");
  };

  const handleCloseAndSaveUser = () => {
    setOpen(false);

    console.log("close and save user");
    console.log("User: [firstName: " + firstname + ", secondName: " + secondName + ",email: " + email + "]");
  };

  return (
    <div>
      <Button variant="outlined" color="primary" onClick={handleClickOpen}>
        + Define new user
      </Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle id="form-dialog-title">Add new User</DialogTitle>

        <DialogContent>
          <TextField
            autoFocus
            margin="dense"
            label="First Name"
            type="text"
            onChange={(event) => setFirstName(event.target.value)}
          />
          <br />
          <TextField
            autoFocus
            margin="dense"
            label="Second Name"
            type="text"
            onChange={(event) => setSecondName(event.target.value)}
          />
          <br />
          <TextField
            autoFocus
            margin="dense"
            label="Email Address"
            type="email"
            onChange={(event) => setEmail(event.target.value)}
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Cancel
          </Button>
          <Button onClick={handleCloseAndSaveUser} color="primary">
            Add User
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}


export default FormDialog;
