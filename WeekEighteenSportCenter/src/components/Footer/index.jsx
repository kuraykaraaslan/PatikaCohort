import "./style.css";
const Footer = () => {
  return (
    <div id="footer">
      <div className="container">
        <img src="./images/logo.png" alt="Logo" />
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis,
          esse mollitia voluptas placeat at impedit quos, quae, quaerat nihil
          molestias incidunt ducimus aspernatur explicabo. Maxime esse porro
          iure iusto! Quidem.
        </p>
        <div className="footerLinks">
          <div className="links">
            <h4>Information</h4>
            <a href="">About Us</a>
            <a href="">Classes</a>
            <a href="">Blog</a>
            <a href="">Contact</a>
          </div>
          <div className="links">
            <h4>Helpful Links</h4>
            <a href="">Services</a>
            <a href="">Supports</a>
            <a href="">Terms & Condition</a>
            <a href="">Privacy Policy</a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Footer;
