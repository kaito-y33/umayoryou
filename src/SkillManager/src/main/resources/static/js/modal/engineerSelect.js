/**
 * エンジニア選択Script.
 */

function openEngineerModal() {
  // 選択済のエンジニアが存在する場合、チェック状態にする
  const selectedEngineerIds = document
    .getElementById("selectedEngineers")
    .value.split(",")
    .filter((id) => id);
  selectedEngineerIds.forEach((id) => {
    const checkBox = document.querySelector(
      `input[type='checkbox'][value='${id}']`
    );
    if (checkBox) {
      checkBox.checked = true;
    }
  });

  $("#engineerModal").draggable({
    handle: ".modal-header",
  });

  document.getElementById("engineerModal").style.display = "block";
}

function closeEngineerModal() {
  document.getElementById("engineerModal").style.display = "none";
}

function updateEngineerSelection(checkBox) {
  let selectedEngineerIds = document
    .getElementById("selectedEngineers")
    .value.split(",")
    .filter((id) => id);

  if (checkBox.checked) {
    if (!selectedEngineerIds.includes(checkBox.value)) {
      selectedEngineerIds.push(checkBox.value);
    }
  } else {
    selectedEngineerIds = selectedEngineerIds.filter(
      (id) => id !== checkBox.value
    );
  }

  document.getElementById("selectedEngineers").value =
    selectedEngineerIds.join(",");
}

function confirmEngineerSelection() {
  let selectedEngineerIds = document
    .getElementById("selectedEngineers")
    .value.split(",")
    .filter((id) => id);

  let selectedEngineerNames = [];

  selectedEngineerIds.forEach((id) => {
    let checkBox = document.querySelector(
      `input[type='checkBox'][value='${id}']`
    );
    if (checkBox) {
      selectedEngineerNames.push(checkBox.getAttribute("data-name"));
    }
  });

  document.getElementById("selectedEngineerNames").value =
    selectedEngineerNames.join(", ");

  closeEngineerModal();
}
