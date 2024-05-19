import "./style.css";
const Hero = () => {
  return (
    <div id="hero" className="heroBackgroundImage">
      <div className="container">
        <div className="hero">
          <h1>POWERFULL</h1>
          <h2>
            Group <span></span> Practise
          </h2>
          <h2>With Trainer</h2>
          <p>
            Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nulla ea
            numquam, unde ducimus quaerat qui impedit rerum sint ratione
            voluptate quia nemo dicta voluptas facere. Ullam, minus adipisci.
            Totam, culpa.
          </p>
          <div className="heroBtns">
            <a href="">Sign Up</a>
            <a href="">Details</a>
          </div>
        </div>
      </div>

      <div className="heroStatisticsBackground">
        <div className="statisticsContainer">
          <div className="statistic">
            <span className="number">325</span>
            <p>Course</p>
          </div>
          <div className="statistic">
            <span className="number">405</span>
            <p>Work Out</p>
          </div>
          <div className="statistic">
            <span className="number">305</span>
            <p>Working Hour</p>
          </div>
          <div className="statistic">
            <span className="number">705</span>
            <p>Happy Client</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Hero;
