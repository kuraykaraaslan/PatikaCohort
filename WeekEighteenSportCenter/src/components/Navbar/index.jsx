import { useEffect, useState } from "react";
import "./style.css";

const anchorItems = [
  "hero",
  "classes",
  "trainers",
  "purchase",
  "review",
  "contact",
];

const Navbar = () => {
  // Navbar Dropdown Menu Actions
  const [dropdownMenu, setDropdown] = useState({
    dropdown: "",
    dropdownIcon: "fa-solid fa-bars",
  });

  const dropdownBtn = () => {
    dropdownMenu.dropdown == ""
      ? setDropdown({
          dropdown: "navbarOpen",
          dropdownIcon: "fa-solid fa-xmark",
        })
      : setDropdown({ dropdown: "", dropdownIcon: "fa-solid fa-bars" });
  };

  // Navbar Page Scroll Event
  const [navbarBackGround, setNavbarBackGround] = useState("");

  document.addEventListener("scroll", () => {
    window.scrollY > 100
      ? setNavbarBackGround("navbarScrollBackground")
      : setNavbarBackGround("");

    setDropdown({ dropdown: "", dropdownIcon: "fa-solid fa-bars" });
  });

  // Close the dropdown menu when click the document except navbar
  useEffect(() => {
    document.addEventListener("click", (e) => {
      if (e.clientY > 60) {
        setDropdown({ dropdown: "", dropdownIcon: "fa-solid fa-bars" });
      }
    });
  }, []);

  // Smooth scroll transition between sections on the page
  const handleClick = (event) => {
    event.preventDefault();

    const sectionId = event.target.getAttribute("href");

    document
      .querySelector(sectionId)
      .scrollIntoView({ behavior: "smooth", block: "start" });
  };

  return (
    <header className={`${navbarBackGround}`}>
      <div className="container">
        <div className="navbar">
          <a href="#hero">
            <img src="./images/logo.png" alt="Logo" />
          </a>

          <div className={`navbarBtns ${dropdownMenu.dropdown}`}>
            {anchorItems.map((item) => (
              <a key={item} onClick={handleClick} href={`#${item}`}>
                {item[0].toUpperCase() + item.slice(1)}
              </a>
            ))}

            <a href="">JOIN US</a>
          </div>
          <div className="navbarDropdownBtn" onClick={dropdownBtn}>
            <i className={`${dropdownMenu.dropdownIcon}`}></i>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Navbar;
