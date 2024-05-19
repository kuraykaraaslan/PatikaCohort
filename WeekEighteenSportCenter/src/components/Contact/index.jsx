import "./style.css";
const Contact = () => {
  return (
    <div id="contact" className="container">
      <div className="sectionHeader">
        <h3>CONTACT US</h3>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Iure dolores
          aliquam, accusantium atque fugiat minima.
        </p>
      </div>

      <div className="contactContainer">
        <div className="appoinment">
          <div className="contacts">
            <div className="contact">
              <p>Mobile Number</p>
              <p>+135 773 321 4442</p>
            </div>

            <div className="contact">
              <p>Email Address</p>
              <p>demo@demo.com</p>
            </div>
          </div>

          <h4>Make An Appoinment</h4>

          <input type="text" placeholder="Your Name" />
          <input type="email" placeholder="Your Email" />
          <textarea
            name=""
            id=""
            cols="30"
            rows="5"
            placeholder="Your Message"
          ></textarea>
        </div>

        <div className="googleMap">
          <iframe
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3009.8916554124617!2d28.967613294902915!3d41.027626244362295!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14cab91ef219e13d%3A0x99c136f220088f3!2sPatika.dev%20-%20Bootcamp!5e0!3m2!1str!2str!4v1713884374515!5m2!1str!2str"
            width="100%"
            height="350"
            style={{ border: 0 }}
            loading="lazy"
            referrerPolicy="no-referrer-when-downgrade"
          ></iframe>
        </div>
      </div>
    </div>
  );
};

export default Contact;
