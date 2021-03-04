import React from "react";
import Button from "@material-ui/core/Button";

function UserLine(props) {
  return (
    <tr>
      <td> {props.id}</td>
      <td> {props.firstname}</td>
      <td> {props.lastname}</td>
      <td> {props.email}</td>
      <td>
        <Button variant="contained" color="primary">
          Edit
        </Button>

        <Button variant="contained" color="secondary">
          Remove
        </Button>
      </td>
    </tr>
  );
}

export default UserLine;
