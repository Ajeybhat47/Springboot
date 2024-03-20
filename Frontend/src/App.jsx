// App.js
import React from "react";
import "./styles.css";
import Login from "./components/login/login"; 
import * as ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";


const router = createBrowserRouter([
  {
    path: "/",
    element:<Login/>
  },
  {
    path:"/login",
    element:<Login/>
  }

])


export default function App() {
  return (
    <div className="App">
      <RouterProvider router={router}/>
    </div>
  );
}
