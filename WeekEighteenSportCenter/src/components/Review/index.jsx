import "./Review.style.css";

const Review = () => {
  return (
    <div id="review">
      <div className="container">
        <div className="sectionHeader">
          <h3>REVIEW CLIENT</h3>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus
            aperiam iusto provident delectus enim quod facilis dolorum illum, a
            ad.
          </p>
        </div>

        <div className="reviews">
          <div className="review">
            <div className="userProfile">
              <img src="./images/client1.jpg" alt="" />
              <div className="userInfo">
                <p className="userJob">Diet Expert</p>
                <p className="userPosition">CFO</p>
              </div>
            </div>
            <div className="userComment">
              <p>
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Labore
                harum illum quis vitae mollitia impedit. Neque suscipit nemo
                sint dolorum dolore, commodi at libero nisi eum. Quo et eum
                dignissimos.
              </p>
              <div className="commentBackground"></div>
            </div>
          </div>
          <div className="review">
            <div className="userProfile">
              <img src="./images/client2.jpg" alt="" />
              <div className="userInfo">
                <p className="userJob">Cardio Trainer</p>
                <p className="userPosition">CEO</p>
              </div>
            </div>
            <div className="userComment">
              <p>
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Labore
                harum illum quis vitae mollitia impedit. Neque suscipit nemo
                sint dolorum dolore, commodi at libero nisi eum. Quo et eum
                dignissimos.
              </p>
              <div className="commentBackground"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Review;
