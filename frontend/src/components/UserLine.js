import React from "react";

function UserLine(props) {
  return (
    <tr>
      <td> {props.id}</td>
      <td> {props.firstname}</td>
      <td> {props.lastname}</td>
      <td> {props.email}</td>
      <td>
        <button className="btn btn-primary btn-sm  btn-lg">Edit User</button>
        <button className="btn btn-danger btn-sm  btn-lg">Remove</button>
      </td>
    </tr>
  );
}

export default UserLine;
