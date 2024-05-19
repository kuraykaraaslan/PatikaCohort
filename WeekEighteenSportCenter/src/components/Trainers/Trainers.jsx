import "./Trainers.style.css";

const Trainers = () => {
  return (
    <div id="trainers">
      <div className="container">
        <div className="sectionHeader">
          <h3>OUR BEST TRAINERS</h3>
          <p>
            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Suscipit
            ex corporis tempore consectetur provident earum voluptatibus vero
            ullam. Ut, sit!
          </p>
        </div>

        <div className="trainerCards">
          <div className="trainerCard">
            <img src="./images/trainer1.jpg" alt="" />
            <div className="cardClip"></div>
            <div className="trainerName">
              <h2>Jane Doe</h2>
              <p>Cardio Trainer</p>
            </div>
          </div>
          <div className="trainerCard">
            <img src="./images/trainer2.jpg" alt="" />
            <div className="cardClip"></div>
            <div className="trainerName">
              <h2>Jane Doe</h2>
              <p>Cardio Trainer</p>
            </div>
          </div>
          <div className="trainerCard">
            <img src="./images/trainer3.jpg" alt="" />
            <div className="cardClip"></div>
            <div className="trainerName">
              <h2>Jane Doe</h2>
              <p>Cardio Trainer</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Trainers;
