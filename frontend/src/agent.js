import superagentPromise from "superagent-promise";
import _superagent from "superagent";

const superagent = superagentPromise(_superagent, global.Promise);

const API_ROOT = "http://localhost:8080";

const encode = encodeURIComponent;
const responseBody = res => res.body;

let token = null;
const tokenPlugin = req => {
    if (token) {
        req.set("Authorization", `Bearer ${token}`);
        console.log("req", req);
    }
};

const requests = {
    del: url =>
        superagent
            .del(`${API_ROOT}${url}`)
            .use(tokenPlugin)
            .then(responseBody),
    get: url =>
        superagent
            .get(`${API_ROOT}${url}`)
            .use(tokenPlugin)
            .then(responseBody),
    put: (url, body) =>
        superagent
            .put(`${API_ROOT}${url}`, body)
            .use(tokenPlugin)
            .then(responseBody),
    post: (url, body) =>
        superagent
            .post(`${API_ROOT}${url}`, body)
            .use(tokenPlugin)
            .accept("json")
            .then(responseBody)
};

const Auth = {
    current: () => requests.get("/api/user"),
    login: (email, password) =>
        requests.post("/api/auth/login", { username: email, password: password }),
    register: user => requests.post("/api/auth/register", user),
    save: user => requests.put("/user", { user })
};

const Tags = {
    getAll: () => requests.get("/tags")
};

const limit = (count, p) => `limit=${count}&offset=${p ? p * count : 0}`;
const omitSlug = article => Object.assign({}, article, { slug: undefined });
const Articles = {
    all: page => requests.get(`/articles?${limit(10, page)}`),
    byAuthor: (author, page) =>
        requests.get(`/articles?author=${encode(author)}&${limit(5, page)}`),
    byTag: (tag, page) =>
        requests.get(`/articles?tag=${encode(tag)}&${limit(10, page)}`),
    del: slug => requests.del(`/articles/${slug}`),
    favorite: slug => requests.post(`/articles/${slug}/favorite`),
    favoritedBy: (author, page) =>
        requests.get(`/articles?favorited=${encode(author)}&${limit(5, page)}`),
    feed: () => requests.get("/articles/feed?limit=10&offset=0"),
    get: slug => requests.get(`/articles/${slug}`),
    unfavorite: slug => requests.del(`/articles/${slug}/favorite`),
    update: article =>
        requests.put(`/articles/${article.slug}`, { article: omitSlug(article) }),
    create: article => requests.post("/articles", { article })
};

const Comments = {
    create: (slug, comment) =>
        requests.post(`/articles/${slug}/comments`, { comment }),
    delete: (slug, commentId) =>
        requests.del(`/articles/${slug}/comments/${commentId}`),
    forArticle: slug => requests.get(`/articles/${slug}/comments`)
};

const Profile = {
    follow: username => requests.post(`/profiles/${username}/follow`),
    get: username => requests.get(`/profiles/${username}`),
    unfollow: username => requests.del(`/profiles/${username}/follow`)
};

const Transaksi = {
    allTransactions: idCust => requests.get(`/transactions/${idCust}`),
    sentMoney: (from, to, fromCode, toCode, recipient, kurs, kursIdr, promoId) =>
        requests.post("/transactions/send", {
            from,
            to,
            fromCode,
            toCode,
            recipient,
            kurs,
            kursIdr,
            promoId
        }),
    changeTransactionStatus: (newValue, idTrans) =>
        requests.post("/admin/transaction/change-status", {
            id: idTrans,
            status: newValue
        })
};

const Recipient = {
    add: (fullname, bank, accountNumber, iban) =>
        requests.post("/recipient/add", { fullname, bank, accountNumber, iban }),
    all: idPengguna => requests.get(`/recipient/all/${idPengguna}`)
};

const Admin = {
    transactions: () => requests.get("/admin/transactions")
};

const Promo = {
    allActive: () => requests.get("/promos/all"),
    buy: id => requests.post("/promo/buy", id)
};

export default {
    Articles,
    Auth,
    Comments,
    Profile,
    Tags,
    Transaksi,
    Recipient,
    Admin,
    Promo,
    setToken: _token => {
        token = _token;
    }
};
