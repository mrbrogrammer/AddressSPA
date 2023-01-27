// import logo from './logo.svg';
import './App.css';
// import {Component} from "react";
import "./App.css";
import React, {useEffect, useState} from "react";
// import { Dropdown } from 'reactstrap';
import "./DropDown.css";
// import * as url from "url";

function App() {

    const Icon = () => {
        return (
            <svg height="20" width="20" viewBox="0 0 20 20">
                <path d="M4.516 7.548c0.436-0.446 1.043-0.481 1.576 0l3.908 3.747 3.908-3.747c0.533-0.481 1.141-0.446 1.574 0 0.436 0.445 0.408 1.197 0 1.615-0.406 0.418-4.695 4.502-4.695 4.502-0.217 0.223-0.502 0.335-0.787 0.335s-0.57-0.112-0.789-0.335c0 0-4.287-4.084-4.695-4.502s-0.436-1.17 0-1.615z"></path>
            </svg>
        );
    };
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

    const [addressId, setAddressId] = useState(0);
    const [line1, setLine1] = useState("");
    const [line2, setLine2] = useState("");
    const [suburb, setSuburb] = useState("");
    const [city, setCity] = useState("");
    const [province, setProvince] = useState("");
    const [postalCode, setPostalCode] = useState("");
    const [country, setCountry] = useState("");
    const [message, setMessage] = useState("");


    let handleSubmit = async (e) => {
        e.preventDefault();
        try {
            let res = await fetch("/api/v1/addresses", {
                method: "POST",
                body: JSON.stringify({
                    addressId: addressId,
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
                setAddressId(Math.floor(Math.random() * 9))
                setLine1("");
                setLine2("");
                setSuburb("");
                setCity("");
                setProvince("");
                setPostalCode("");
                setCountry("")

                setMessage("User created successfully");
            } else {
                setMessage("Invalid!");
            }
        } catch (err) {
            console.log(err);
        }
    };

    const [countryMenu, setCountryMenu] = useState(false);
    const [provinceMenu, setProvinceMenu] = useState(false);
    const [selectedCountryValue, setSelectedCountryValue] = useState(null);
    const [selectedProvinceValue, setSelectedProvinceValue] = useState(null);

    useEffect(() => {
        const provinceHandler = () => setProvinceMenu(false);
        const countryHandler = () => setCountryMenu(false);
        window.addEventListener("click",  provinceHandler);
        window.addEventListener("click",  countryHandler);
        console.log("clicked");
        return () => {
            window.removeEventListener("click", provinceHandler);
            window.removeEventListener("click", countryHandler);
        };
    });

    const handleProvinceInputClick = (e) => {
        e.stopPropagation();
        setProvinceMenu(!provinceMenu);
    }
    const handleCountryInputClick = (e) => {
        e.stopPropagation();
        setCountryMenu(!countryMenu);
    }
    const getProvinceDisplay = () => {
        if (selectedProvinceValue) {
            return selectedProvinceValue.name;
        }
        return "Province"
    };
    const getCountryDisplay = () => {
        const ps = selectedCountryValue;
        if (ps) {
            return ps.name;
        }

        return "Country"
    };

    const onItemCountryClick = (option) => {
        setSelectedCountryValue(option);
    };
    const onItemProvinceClick = (option) => {;
        setSelectedProvinceValue(option);
    };

    const handleCountryChange = event => {
        setCountry(event.target.innerText);

        console.log('value is:', event.target.innerText);
    };
    const handleProvinceChange = event => {
        setProvince(event.target.innerText);

        console.log('value is:', event.target.innerText);
    };

    let e;
    return (
        <div className="App">
            <form onSubmit={handleSubmit}>
                <input
                    required
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
                    <div onClick={handleCountryInputClick} className="dropdown-input">
                        <div
                            className="dropdown-selected-value"
                            onChange={handleCountryChange}
                            onEmptiedCapture={handleCountryChange}
                            onLoadedData={handleCountryChange}
                            >
                            {getCountryDisplay()}
                        </div>
                        { countryMenu && (
                            <div className="dropdown-menu">
                                {countries.map ((option) => (
                                    <div
                                        onClickCapture={handleCountryChange}
                                        onClick={() =>
                                            onItemCountryClick(option)
                                        }
                                        key={option.countryCode}
                                        className={'dropdown-item ${isSelected (option) && "selected"}'}>
                                        {option.name}
                                    </div>
                                ))}
                            </div>
                        )}
                        <div className="dropdown-tools">
                            <div className="dropdown-tool">
                                <Icon />
                            </div>
                        </div>
                    </div>
                </div>

                <div className="dropdown-container">
                    <div onClick={handleProvinceInputClick} className="dropdown-input">
                        <div
                            className="dropdown-selected-value"
                            onChange={handleProvinceChange}
                            onEmptiedCapture={handleProvinceChange}
                            onLoadedData={handleProvinceChange}
                        >
                            {getProvinceDisplay()}
                        </div>

                        { provinceMenu && (
                            <div className="dropdown-menu">
                                {provinces.map ((option) => (
                                    <div
                                        onClickCapture={handleProvinceChange}
                                        onClick={() => onItemProvinceClick(option)}
                                        key={option.provinceId}
                                        className={'dropdown-item ${isSelected (option) && "selected"}'}>
                                        {option.name}
                                    </div>
                                ))}
                            </div>
                        )}
                        <div className="dropdown-tools">
                            <div className="dropdown-tool">
                                <Icon />
                            </div>
                        </div>
                    </div>
                </div>

                <input
                    required
                    type="text"
                    value={city}
                    placeholder="City"
                    onChange={(e) => setCity(e.target.value)}
                />
                <input
                    minLength={3}
                    maxLength={7}
                    pattern={"^([0-9]+)+$"}
                    required
                    type="text"
                    value={postalCode}
                    placeholder="Postal Code"
                    onChange={(e) => setPostalCode(e.target.value)}
                />

                <button type="submit">Create</button>

                <div className="message">{message ? <p>{message}</p> : null}</div>
            </form>
        </div>
    );

}
export default App;
