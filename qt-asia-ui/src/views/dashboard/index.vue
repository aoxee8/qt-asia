<template>
  <div class="dashboard-container">
    <div class="dashboard-text"></div>
  </div>
</template>

<script>

export default {
  name: 'Dashboard',
  mounted() {
    this.$router.push('/article')
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
