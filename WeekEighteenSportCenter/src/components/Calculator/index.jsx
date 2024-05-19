import { useEffect, useState } from "react";
import "./style.css";

let caretLocation;

const Calculator = () => {
  const [inputValue, setInputValue] = useState({ height: "", weight: "" });
  const [message, setMessage] = useState("");
  const [bmiResult, setBmiResult] = useState("");

  const handleChange = (e) => {
    if (e.target.id === "height") {
      setInputValue({ ...inputValue, height: e.target.value });
    } else {
      setInputValue({ ...inputValue, weight: e.target.value });
    }
  };

  useEffect(() => {
    if (inputValue.height != "") {
      if (Number(inputValue.height) < 120 || Number(inputValue.height) > 240) {
        setMessage("Your height should between 120 cm and 240 cm.");
      } else if (
        Number(inputValue.weight) < 40 ||
        Number(inputValue.weight) > 240
      ) {
        setMessage("Your weight should between 40 kg and 240 kg.");
      } else {
        caretLocation =
          (Number(inputValue.weight) / (Number(inputValue.height) / 100) ** 2 -
            13) *
            (80 / 27.5) +
          9;
        setBmiResult(
          (Number(inputValue.weight) / (Number(inputValue.height) / 100) ** 2)
            .toString()
            .slice(0, 4)
        );
        setMessage("");
      }
    }

    caretLocation < 9
      ? (caretLocation = "9%")
      : caretLocation > 89
      ? (caretLocation = "89%")
      : (caretLocation = `${caretLocation}%`);
  }, [inputValue]);

  return (
    <div id="calculator" className="container">
      <div className="calculator">
        <h4>BMI Calculator</h4>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Eos dolores
          ex et sequi porro facere, enim dolorum dolore, iure libero in
          voluptate itaque? Dignissimos sunt deleniti eligendi at similique
          totam.
        </p>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates
          officia cumque neque magnam ipsam voluptas qui, voluptate eveniet
          quae, veniam corrupti maiores itaque sint. Earum, dolor iure!
          Delectus, libero. Non.
        </p>

        <div className="inputsContainer">
          <div className="inputContainer">
            <input
              type="number"
              value={inputValue.height}
              id="height"
              placeholder="Your Height"
              onChange={handleChange}
            />
            <label htmlFor="height">cm</label>
          </div>

          <div className="inputContainer">
            <input
              type="number"
              value={inputValue.weight}
              id="weight"
              placeholder="Your Weight"
              onChange={handleChange}
            />
            <label htmlFor="weight">kg</label>
          </div>
        </div>
        <span className="required">{message}</span>
      </div>
      <div className="calculatorResult">
        <p>
          Your BMI
          <span className="bmiResult">
            {`: ${bmiResult} kg/m`}
            <sup>2</sup>
          </span>
        </p>
        <div className="image">
          <img src="./images/bmi-index.jpg" alt="BMI Index" />
          <span style={{ left: caretLocation }} className="calculatorCaret">
            <i className="fa-solid fa-caret-up"></i>
          </span>
        </div>
      </div>
    </div>
  );
};

export default Calculator;
