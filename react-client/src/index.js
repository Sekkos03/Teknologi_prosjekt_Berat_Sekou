import React from "react";
import { createRoot } from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
  Route,
  Link,
  Outlet,
  createRoutesFromElements
} from "react-router-dom";
import Support from "./routes/Support";
import Home from "./routes/Home";
import Navbar from "./components/Navbar";
import "./App.css";
import "./index.css";
import Class from "./routes/Class";
import Submission from "./routes/Submission";
import Chat from "./routes/Chat";

const AppLayout = () => (
  <>
    <Navbar />
    <Outlet />
  </>
);

// const router = createBrowserRouter(
//   createRoutesFromElements(
//     <Route element={<AppLayout />}>
//       <Route path="/" element={<Home />} />
//       <Route path="/products" element={<Products />} />
//       <Route path="/reports" element={<Reports />} />
//     </Route>
//   )
// );

const router = createBrowserRouter([
  {
    element: <AppLayout />,
    children: [
      {
        path: "/",
        element: <Home />
      },
      {
        path: "support",
        element: <Support />
      },
      {
        path: "messages",
        element: <Chat />
      },
      {
        path: "submission",
        element: <Submission />
      },
      {
        path: "class",
        element: <Class />
      }
    ]
  }
]);

createRoot(document.getElementById("root")).render(
  <RouterProvider router={router} />
);
