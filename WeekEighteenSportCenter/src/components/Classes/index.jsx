import { useState } from "react";
import "./style.css";

import data from "../../data/class.json";

const Classes = () => {
  const [selected, setSelected] = useState("yoga");

  const handleButton = (e) => {
    e.preventDefault();
    setSelected(e.target.id);
  };

  return (
    <div id="classes">
      <div className="classesBackgroundClip"></div>
      <div className="container">
        <div className="sectionHeader">
          <h3>OUR CLASSES</h3>
          <p>
            Lorem ipsum, dolor sit amet consectetur adipisicing elit. At harum
            minus rem doloremque tempore delectus.
          </p>
        </div>

        <div className="classesBtns">
          {Object.keys(data).map((key) => (
            <a
              key={key}
              id={key}
              className={`classesBtn ${selected === key ? "selected" : ""}`}
              onClick={handleButton}
              href=""
            >
              {key.charAt(0).toUpperCase() + key.slice(1)}
              <span className={`caret ${selected === key ? "" : "hidden"}`}>
                <i className="fa-solid fa-caret-down"></i>
              </span>
            </a>
          ))}
        </div>

        <div id={data[selected].id} className="classes">
          <div className="information">
            <h4>{data[selected].firstQuestion}</h4>
            <p>{data[selected].information}</p>
            <h4>{data[selected].secondQuestion}</h4>
            <p>{data[selected].firstProgram}</p>
            <p>{data[selected].secondProgram}</p>
            <p>{data[selected].thirdrogram}</p>
          </div>
          <img src={data[selected].image} alt={data[selected].id} />
        </div>
      </div>
    </div>
  );
};

export default Classes;
