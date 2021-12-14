import { useCallback } from "react";
import { useAppDispatch } from "www/store/hooks";
import { screenPushed } from "www/widgets/ScreenStackWidget/actions";

export function EntityListItem({ entity }: any) {
  const dispatch = useAppDispatch();
  const go = useCallback(
    () => dispatch(screenPushed("entity", entity.id)),
    [dispatch, entity]
  );

  const { type, name, owner } = entity;
  let potatoIcon = "";
  if (type === "ship" && entity.resources["potato"].maximum > 0) {
    potatoIcon = "\ud83e\udd54";
  } else {
    potatoIcon = "";
  }
  return (
    <li
      onClick={go}
      data-testid="entity-list-item"
      style={{ textDecoration: "underline", cursor: "pointer" }}
    >
      {type}: {name}
      {owner && ` of ${owner}`}
      {potatoIcon}
    </li>
  );
}
