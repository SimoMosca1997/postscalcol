const express = require('express');
const app = express();
const port = process.env.PORT || 8080;

// Funzione di calcolo
function calculateMetrics(engagement, follower, sixMax) {
    const reach = (engagement / sixMax) * follower;
    const emv = reach * 0.0325;
    const reachH = 0.30 * follower;

    return {
        reach: reach,
        emv: emv,
        reachH: reachH
    };
}

// Endpoint per il calcolo
app.get('/calculate', (req, res) => {
    const engagement = parseFloat(req.query.engagement);
    const follower = parseFloat(req.query.follower);
    const sixMax = parseFloat(req.query.sixMax);

    if (isNaN(engagement) || isNaN(follower) || isNaN(sixMax)) {
        return res.status(400).json({ error: 'I parametri engagement, follower e sixMax devono essere numerici.' });
    }

    const result = calculateMetrics(engagement, follower, sixMax);
    res.json(result);
});

app.listen(port, () => {
    console.log(`Server in ascolto su http://localhost:${port}`);
});

