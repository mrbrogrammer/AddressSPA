// import logo from './logo.svg';
import './App.css';
// import {Component} from "react";
import "./App.css";
import React, {useEffect, useState} from "react";
// import { Dropdown } from 'reactstrap';
import Dropdown from "./DropDown.css";
// import * as url from "url";

function App() {



    const [countries, setCountries] = useState([]);
    const [provinces, setProvinces] = useState([]);

    useEffect(() => {

        const fetchData = async () => {
            try {
                const countryResponse = await fetch("/api/v1/countries");
                const provinceResponse = await fetch("/api/v1/provinces");
                const country = await countryResponse.json();
                const province = await provinceResponse.json();
                console.log(country);
                console.log(province);
                setCountries(country);
                setProvinces(province);
            } catch (error) {
                console.log("error", error);
            }
        };

        fetchData();
    }, []);



    // console.log(countries)

    const [line1, setLine1] = useState("");
    const [line2, setLine2] = useState("");
    const [suburb, setSuburb] = useState("");
    const [city, setCity] = useState("");
    const [province, setProvince] = useState("");
    const [postalCode, setPostalCode] = useState("");
    const [country, setCountry] = useState("");


    let handleSubmit = async (e) => {
        e.preventDefault();
        try {
            let res = await fetch("/api/v1/addresses", {
                method: "POST",
                body: JSON.stringify({
                    line1: line1,
                    line2: line2,
                    suburb: suburb,
                    city: city,
                    province: province,
                    postalCode: postalCode,
                    country: country
                }),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                },
            });
            let resJson = await res.json();
            if (res.status === 200) {
                setLine1("");
                setLine2("");
                setSuburb("");
                setCity("");
                setProvince("");
                setPostalCode("");
                setCountry("")

                // setMessage("User created successfully");
            } else {
                // setMessage("Some error occured");
            }
        } catch (err) {
            console.log(err);
        }
    };

    const [showMenu, setShowMenu] = useState(false);
    const [selectedValue, setSelectedValue] = useState(null);

    useEffect(() => {
        const handler = () => setShowMenu(false);
        window.addEventListener("click", handler);
        console.log("clicked");
        return () => {
            window.removeEventListener("click", handler);
        };
    });

    const handleInputClick = (e) => {
        e.stopPropagation();
        setShowMenu(!showMenu);
    }
    const getDisplay = () => {
        if (selectedValue) {
            return selectedValue.name;
        }
        return placeHolder;
    };

    const onItemClick = (option) => {
        setSelectedValue(option);
    };
    const isSelected = (option) => {
        if (!selectedValue) {
            return false;
            return selectedValue.name
        }
    }


    return (
        <div className="App">
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={line1}
                    placeholder="Line 1"
                    onChange={(e) => setLine1(e.target.value)}
                />
                <input
                    type="text"
                    value={line2}
                    placeholder="Line 2"
                    onChange={(e) => setLine2(e.target.value)}
                />
                <input
                    type="text"
                    value={suburb}
                    placeholder="Suburb"
                    onChange={(e) => setSuburb(e.target.value)}
                />
                <div className="dropdown-container">
                    <div onClick={handleInputClick} className="dropdown-input">
                        <input
                            placeholder="Country"
                            value={getDisplay()}
                            className="dropdown-selected-value"
                            onChange={(e) => setCountry(e.target.value)}>
                        </input>
                        { showMenu && (
                            <div className="dropdown-menu">
                                {countries.map ((option) => (
                                    <div
                                        onClick={() => onItemClick (option)}
                                        key={option.countryCode ? option.countryCode : option.provinceId}
                                        className={'dropdown-item ${isSelected (option) && "selected"}'}>
                                        {option.name}
                                    </div>
                                ))}
                            </div>
                        )}
                        {/*<div className="dropdown-tools">*/}
                        {/*    <div className="dropdown-tool">*/}
                        {/*        <Icon />*/}
                        {/*    </div>*/}
                        {/*</div>*/}
                    </div>
                </div>

                {/*<Dropdown*/}
                {/*    placeHolder="Province"*/}
                {/*    options={provinces}*/}
                {/*    setVal={setProvince}*/}
                {/*/>*/}

                <input
                    type="text"
                    value={city}
                    placeholder="City"
                    onChange={(e) => setCity(e.target.value)}
                />
                {/*<input*/}
                {/*    type="text"*/}
                {/*    value={province}*/}
                {/*    placeholder="Province"*/}
                {/*    onChange={(e) => setProvince(e.target.value)}*/}
                {/*/>*/}
                <input
                    type="text"
                    value={postalCode}
                    placeholder="Postal Code"
                    onChange={(e) => setPostalCode(e.target.value)}
                />
                {/*<input*/}
                {/*    type="text"*/}
                {/*    value={country}*/}
                {/*    placeholder="Country"*/}
                {/*    onChange={(e) => setCountry(e.target.value)}*/}
                {/*/>*/}

                <button type="submit">Create</button>

                {/*<div className="message">{message ? <p>{message}</p> : null}</div>*/}
            </form>
        </div>
    );


    //
    // state = {
    //   countries: [],
    //   provinces: []
    //
    //
    // };
    //
    // async componentDidMount() {
    //   const [name, setName] = useState("");
    //   const [email, setEmail] = useState("");
    //   const [mobileNumber, setMobileNumber] = useState("");
    //   const [message, setMessage] = useState("");
    //
    //   const CountryResponse = await fetch('/api/v1/countries');
    //   const ProvinceResponse = await fetch('/api/v1/provinces');
    //   const CountryBody = await CountryResponse.json();
    //   const ProvinceBody = await ProvinceResponse.json();
    //   console.log(CountryBody);
    //   console.log(ProvinceBody);
    //   this.setState({countries: CountryBody});
    //   this.setState({provinces: ProvinceBody});
    // }
    //
    // render() {
    //   const {countries} = this.state;
    //   const {provinces} = this.state;
    //
    //   return (
    //       <div className="App">
    //         <header className="App-header">
    //           <img src={logo} className="App-logo" alt="logo" />
    //           <div className="App-intro">
    //             <h2>countries</h2>
    //             {countries.map(country =>
    //                 <div key={country.countryCode}>
    //                   {country.countryCode} ({country.name})
    //                 </div>
    //             )}
    //           </div>
    //           <div className="App-intro">
    //             <h2>Provinces</h2>
    //             {provinces.map(province =>
    //                 <div key={province.provinceId}>
    //                   {province.provinceId.provinceCode} {province.provinceId.countryCode} ({province.name})
    //                 </div>
    //             )}
    //           </div>
    //         </header>
    //       </div>
    //   );
    // }
}
export default App;
