import React, { useState, useEffect } from "react";
import axios from "axios";

const App = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [user, setUser] = useState()

    useEffect(() => {
        const loggedInUser = localStorage.getItem("user");
        if (loggedInUser) {
            //const foundUser = JSON.parse(loggedInUser);
            const foundUser = loggedInUser;
            setUser(foundUser);
        }
    }, []);

    const handleLogout = () => {
        setUser({});
        setEmail("");
        setPassword("");
        localStorage.clear();
    }


    const handleSubmit = async e => {
        e.preventDefault();
        const user = { email, password };

        const response = await axios.post(
            "http://localhost:8080/auth/login",
            user);

        setUser(response.data)
        localStorage.setItem('user', response.data)
        console.log(response.data)
    };

    if (user) {
        return (
            <div>
                {user.name} is logged in
                <button onClick={handleLogout}>logout</button>
            </div>
        );
    }
    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="email">Email: </label>
            <input
                type="text"
                value={email}
                placeholder="enter your email"
                onChange={({ target }) => setEmail(target.value)}
            />
            <div>
                <label htmlFor="password">password: </label>
                <input
                    type="password"
                    value={password}
                    placeholder="enter a password"
                    onChange={({ target }) => setPassword(target.value)}
                />
            </div>
            <button type="submit">Login</button>
        </form>
    );
};

export default App;
