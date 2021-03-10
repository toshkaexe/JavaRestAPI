import React from "react";
import { DeleteItem } from "./DeleteItem";
import { EditItem } from "./EditItem";

function UserLine(props) {
  return (
    <tr>

      <td> {props.firstname}</td>
      <td> {props.lastname}</td>
      <td> {props.email}</td>
      <td>
        <EditItem id={props.id} firstName={props.firstname} lastName={props.lastname} email={props.email} />
        <DeleteItem id={props.id}/>
      </td>
    </tr>
  );
}

export default UserLine;
