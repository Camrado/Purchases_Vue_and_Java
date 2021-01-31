export const CategoriesTable = {
  namespaced: true, //? If it's true, we can have the same states in other modules, and there will be no error.

  state: {
    url: "http://localhost:8080/purchases/back-end/categories",
    content: [],
  },

  mutations: {
    PUSH_CONTENT(state, content) {
      state.content.push(content);
    },
    NULL_CONTENT(state) {
      state.content = [];
    },
  },

  actions: {
    async SELECT_DATA({ commit, getters }) {
      commit("NULL_CONTENT"); //? Clearing data before adding new one

      const response = await fetch(getters.GET_URL + "/get/all", { Accept: "application/json" });
      const data = await response.json();

      for (let i = 0; i < data.length; i++) {
        commit("PUSH_CONTENT", data[i]);
      }
    },
  },

  getters: {
    GET_CONTENT: (state) => state.content,
    GET_URL: (state) => state.url,
  },
};
