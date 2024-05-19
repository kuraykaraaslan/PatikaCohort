import "./Homepage.style.css";
import Navbar from "../../components/Navbar";
import Hero from "../../components/Hero";
import Classes from "../../components/Classes";
import Calculator from "../../components/Calculator";
import Trainers from "../../components/Trainers";
import Purchase from "../../components/Purchase";
import Review from "../../components/Review";
import Contact from "../../components/Contact";
import Footer from "../../components/Footer";

const Homepage = () => {
  return (
    <>
      <Navbar />
      <Hero />
      <Classes />
      <Calculator />
      <Trainers />
      <Purchase />
      <Review />
      <Contact />
      <Footer />
    </>
  );
};

export default Homepage;
