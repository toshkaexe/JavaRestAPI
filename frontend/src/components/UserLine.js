import React from "react";
import { DeleteItem } from "./DeleteItem";
import { EditItem } from "./EditItem";

function UserLine(props) {
  return (
    <tr>
      <td> {props.id}</td>
      <td> {props.firstname}</td>
      <td> {props.lastname}</td>
      <td> {props.email}</td>
      <td>
        <EditItem />
        <DeleteItem />
      </td>
    </tr>
  );
}

export default UserLine;
